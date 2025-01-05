**About This Tutorial**


![image](uploads/7e766148270fd32ad121f48164e0b921/image.png)

Android is an open-source mobile operating system based on Java language and Linux kernel. It runs on different handheld mobile devices such as smartphones, tablets, switches, TV, etc. Android was developed by Android Inc. and is now led by Google which purchased it in 2005. This tutorial will illustrate the basics of Android development through “Hello World” and “Change me” examples. To be satisfied with this material, please review the introductory lecture notes. 

**What You'll Learn:**

After finishing this tutorial, you'll be familiar with some Android words. You'll also be able to start a new project, create basic designs, write simple code, and run your app on a real or virtual device.

**What You Need:**

You'll need space on your computer to install Android Studio if you want to use your own. If you have an Android device, you can grab a USB cable to connect it to your computer. It's faster to test your apps on a real device than a virtual one. Don't worry if you don't have your own; you can ask the LTU Media Centre to lend you a tablet for the semester. Let's get started!

**Hello World Example**

1. Install Android Studio 
For guidance on installing Android Studio, exploring its features, and understanding how to use it, visit https://developer.android.com/studio/?utm_source=android-studio. This link offers access to the latest stable version, with Android Studio Koala | 2024.1.1 being the most recent version during the instalation of Android on our Linux VMs. Please use this version as the code in this tutorial is tested on this version. 

2. Start you Linux VM and search apps for Android Studio, click on it and you will have the following screen: 

![image](https://github.com/user-attachments/assets/2fd3910d-3727-4aa1-af95-39f7e4aaac8b)


3. Press on the ‘New Project’ Button and the following screen will appear:

![image](https://github.com/user-attachments/assets/23e4d8d3-4de4-4884-af25-8ff85c96ce3d)

4. Keep the default selections as we will develop apps for “Phone and Tablet” and we will select an “Empty Views Activity” to start our project, press Next when you are ready and the following screen will appear:

![image](https://github.com/user-attachments/assets/633a331a-7c30-46c5-967c-141218a2bfd9)

5. Change the name of the project to “MyFirstApplication” and the language to Java instead of Kotlin. Select the project location and keep the default value for the package and the minimum SDK.

- _It is preferred to keep all the examples in one folder and name it “Android App Development”._ 

6. Click Finish to see your app created with an Activity (Java-based file) called MainActivity and a Layout (XML-based file) called activity_main. Creating android projects may take some time as the Build system 'Gradle' needs to build all the dependency, so don't touch anything while the system is busy with building your app. If your project is created successfully, you will see the following project screen:

![image](https://github.com/user-attachments/assets/a2a4bc16-22c4-4f69-a4ca-35bd6554745e)

_**Now you are ready to run your application**_

7. Click the Run menu and select Run ‘app’ command according to the following screen:

![image](https://github.com/user-attachments/assets/872c190a-6120-4315-ac96-0007b921048e)
 
8. We have already created a virtual device for you to run your app but if you use your own laptop, you will need to create a virtual device or connect a real device.
  
This process may take a long time to finish and it can take longer if you use a virtual device. 
Well done you have created your first ‘Hello World’ app.

**Now time for coding…**

**Change Me Example**

1. Expand the app files on the left-hand side and then expand the ‘res’ folder, scroll down to the layout folder and expand it, click on ‘activity_main.xml’ and  the UI design will be shown on your screen as follows:

![image](https://github.com/user-attachments/assets/8d51d715-2a81-4780-b2a4-d2aaa29970c7)

- Now you can be creative and design your UI.
 
2. Delete the ‘Hello World!’ TextView by clicking it and then pressing ‘delete’ button from your keyboard. 

3. From the palette (in the above screen) where all Widgets are available, add a TextView and a Button to your project by clicking, dragging and dropping on the activity design in the required location. 

4. Click the Button as in the screen above and change the ID on the right-hand side to ‘firstButton’ and create an event on the onClick option named ‘pressMeButton’. The design will look like the following screen:

![image](https://github.com/user-attachments/assets/30dd9021-0ca2-4b70-b06b-b6f176d34853)
 
5. Click on the Code button at the top right of the screen above and the xml code will appear as follow: 

![image](https://github.com/user-attachments/assets/36ccf6db-a9a9-4bcc-8b36-ad2a1d160e81)
 
6. Move the pointer to the ‘pressMeButton’ event and a small help light bulb will appear. Press on the option ‘Create ‘pressMeButton(View)’ in ‘MainActivity’’ option or write the code yourself:

7. A public method called ‘pressMeButton’ is created in the ‘MainActivity’ as in the screen below:

![image](https://github.com/user-attachments/assets/c586ba92-b449-4c4d-aaa9-c40e72a415b6)
 
- Now we need to write our code inside this method.


**Change Me idea is very simple for now:**

If we press the button we want the text in the TextView to be changed to “Find a great idea for the next app”. 

8. To do so, define two variables to match the two types of views as below:

![image](https://github.com/user-attachments/assets/c03dd126-d367-4276-b34a-52a04a91bc00)

9. The two variables are in red colour which means more classes are required to be imported by the system. To resolve this click Alt + Enter and click Import class.
 
- Now everything is fine, let's continue coding:
 
10. Add the following code inside the method onCreate() to find the views by their IDs. The onCreate() method is one of many methods that are fired when an activity is loaded.  
 
11. Now write the following code in the pressMeButton() method.

![image](https://github.com/user-attachments/assets/75e2f73c-5d5a-4965-b1a1-036c3d174864)

 
The code will look like this in the MainActivity.java.
 
```java
public class MainActivity extends AppCompatActivity {
    TextView newText;
    Button changeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        newText = findViewById(R.id.textView);
        changeButton = findViewById(R.id.firstButton);
    }

    public void pressMeButton(View view) {
        newText.setText("Find a great idea for the next app");

    }
}
```

12. Add a layout constraint to your UI design by connecting the views to the parent. Change the text of the TextView to “change me” and the text of pressMeButton to “Click me”.
 
The xml code in the activity_main.xml will look like the following: 
```xml
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="32dp"
        android:layout_marginTop="151dp"
        android:layout_marginEnd="32dp"
        android:text="Change me"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/firstButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="32dp"
        android:layout_marginTop="168dp"
        android:layout_marginEnd="32dp"
        android:onClick="pressMeButton"
        android:text="Press Me"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView" />
</androidx.constraintlayout.widget.ConstraintLayout>
```
13. Let us run the app again, remember to click on the Run list and press Run app command. You will have the following screens:
 
![image](https://github.com/user-attachments/assets/c4eeb3e2-3746-45dd-b660-106b573e3d69)

**What’s Next**

To strengthen your grasp of Android fundamentals and expand your dev toolkit, it's recommended to explore Chapter 1 in the book "Head First Android Development, 3rd Edition," accessible at oreilly.com. Note: Although this book primarily uses Kotlin as the programming language, Chapter 1 is comprehensive and covers everything necessary to commence Android development.

Exercise 1: Develop a simple calculator using Android Studio. 
(Note: this needs to be submitted with the first example).
![image](https://github.com/DrAShabut/AndroidDev/assets/146723487/5542a98b-b56d-4fb5-a035-d55d32dc55f2)

Here is the blueprint to know the names of views.
![image](https://github.com/DrAShabut/AndroidDev/assets/146723487/58c0cdd3-28de-483c-b288-74a8c0585288)

