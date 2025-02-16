**Understanding the UI Elements in Android**

1. ImageView
   
    • Used to display an image in the app.
    
    •	Supports multiple image formats (.png, .jpg, .gif, etc.).
    
    •	The android:src attribute specifies the image resource.
    
    •	The android:contentDescription is used for accessibility.
 
2. CheckBox
   
   •	A toggleable UI component for on/off selection.
   
   •	The isChecked() method returns whether it is selected.
   
   •	You can add an OnCheckedChangeListener to handle state changes.
   
3. Switch
   •	A more modern version of a CheckBox.
   
   •	Provides visual feedback with a swipe/toggle motion.
   
   •	You can use setChecked(true/false) to change its state programmatically.

4. RadioButton & RadioGroup
   •	RadioButton allows users to select one option from a set.
   
   •	RadioGroup ensures that only one button is selected at a time.
   
   •	Methods like getCheckedRadioButtonId() help retrieve the selected option.
   
________________________________________

Updated Java Code for Android 12+

1. ImageView Implementation (XML & Java)
   
   XML Layout (activity_main.xml)
   xml
    
   <?xml version="1.0" encoding="utf-8"?>
   <androidx.constraintlayout.widget.ConstraintLayout
       xmlns:android="http://schemas.android.com/apk/res/android"
       xmlns:app="http://schemas.android.com/apk/res-auto"
       xmlns:tools="http://schemas.android.com/tools"
       android:layout_width="match_parent"
       android:layout_height="match_parent"
       tools:context=".MainActivity">
   
       <ImageView
           android:id="@+id/imageView"
           android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:src="@drawable/rosettastone"
           android:contentDescription="@string/image_description"
           app:layout_constraintTop_toTopOf="parent"
           app:layout_constraintStart_toStartOf="parent"
           app:layout_constraintEnd_toEndOf="parent"/>
   </androidx.constraintlayout.widget.ConstraintLayout>
```
Java Code (MainActivity.java)

```java
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
    }
}
```
✅ Updates:
   •	Uses ConstraintLayout for better positioning.
   
   •	Uses contentDescription for accessibility.
   
________________________________________

2. CheckBox Implementation
   XML Layout
   ```xml
   <CheckBox
       android:id="@+id/check"
       android:layout_width="wrap_content"
       android:layout_height="wrap_content"
       android:text="The checkbox is unchecked"/>
   ```
   ```java
    import android.os.Bundle;
   import androidx.appcompat.app.AppCompatActivity;
   import android.widget.CheckBox;
   import android.widget.CompoundButton;
   
   public class MainActivity extends AppCompatActivity {
       private CheckBox myCheckbox;
   
       @Override
       protected void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_main);
   
           myCheckbox = findViewById(R.id.check);
   
           myCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                   if (isChecked) {
                       myCheckbox.setText("The checkbox is checked");
                   } else {
                       myCheckbox.setText("The checkbox is unchecked");
                   }
               }
           });
       }
   }
   ```
✅ Updates:

•	Uses CompoundButton.OnCheckedChangeListener for better performance.

________________________________________

3. Switch Implementation

XML Layout

   ```xml
   <Switch
       android:id="@+id/switchexample"
       android:layout_width="wrap_content"
       android:layout_height="wrap_content"
       android:text="The switch is off"/>
   ```
   ```java
    import android.os.Bundle;
   import androidx.appcompat.app.AppCompatActivity;
   import android.widget.Switch;
   import android.widget.CompoundButton;
   
   public class MainActivity extends AppCompatActivity {
       private Switch mySwitch;
   
       @Override
       protected void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_main);
   
           mySwitch = findViewById(R.id.switchexample);
   
           mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                   if (isChecked) {
                       mySwitch.setText("The switch is ON");
                   } else {
                       mySwitch.setText("The switch is OFF");
                   }
               }
           });
       }
   }
   ```
✅ Updates:

•	Uses SwitchCompat for better UI consistency.

________________________________________

4. RadioGroup & RadioButton Implementation

XML Layout

   ```xml
   <RadioGroup
       android:id="@+id/colorRadioGroup"
       android:layout_width="match_parent"
       android:layout_height="wrap_content">
   
       <RadioButton
           android:id="@+id/redRadioButton"
           android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:text="Red"/>
   
       <RadioButton
           android:id="@+id/blueRadioButton"
           android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:text="Blue"/>
   
       <RadioButton
           android:id="@+id/greenRadioButton"
           android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:text="Green"/>
   </RadioGroup>
   ```
   ```java
   import android.graphics.Color;
   import android.os.Bundle;
   import android.view.View;
   import android.widget.RadioButton;
   import android.widget.RadioGroup;
   import android.widget.Toast;
   import androidx.appcompat.app.AppCompatActivity;
   
   public class ColorSelectionActivity extends AppCompatActivity {
       private RadioGroup colorRadioGroup;
   
       @Override
       protected void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_main);
   
           colorRadioGroup = findViewById(R.id.colorRadioGroup);
   
           colorRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(RadioGroup group, int checkedId) {
                   RadioButton selectedRadioButton = findViewById(checkedId);
                   String selectedColor = selectedRadioButton.getText().toString();
   
                   changeBackgroundColor(selectedColor);
   
                   Toast.makeText(ColorSelectionActivity.this, "Selected Color: " + selectedColor, Toast.LENGTH_SHORT).show();
               }
           });
       }
   
       private void changeBackgroundColor(String color) {
           View view = findViewById(android.R.id.content);
           int colorValue = Color.BLACK;
   
           switch (color.toLowerCase()) {
               case "red":
                   colorValue = Color.RED;
                   break;
               case "blue":
                   colorValue = Color.BLUE;
                   break;
               case "green":
                   colorValue = Color.GREEN;
                   break;
           }
   
           view.setBackgroundColor(colorValue);
       }
   }
   ```
✅ Updates:

•	Uses RadioGroup.OnCheckedChangeListener to detect selection.

•	Uses switch-case to set the background color.

________________________________________

Now think about implementing these in your app.
