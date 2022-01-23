**About the Tutorial**

![image](uploads/ff971689644c8b4dcbb0f7d1aeb6be01/image.png)

 
This tutorial will illustrate the basics of Layout – UI elements in Android. This is just an example of how to use one type of layout. You need to read and practice more examples on Android Developer Website.
 

**Exercise 1: Send Message Design**

Open a new project and design the send message activity as in Figure 1 below. Use the constraintLayout container to hold one EmailText, two PlainText and one Button. Access the XML file and change the code as in the code below.
 
![image](uploads/940f012f4c0c25900c2e1d7c66831827/image.png)

Figure 1: Send message design.

![image](uploads/7feb9c5f7e0eaace9769e6e57c67d748/image.png)

Figure 2: Android Studio design layout.


**Final XML code**

__**Note: don’t copy and paste the code, just use it as a guide to your design.**__

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <EditText
        android:id="@+id/editTextTextEmailAddress"
        android:layout_width="411dp"
        android:layout_height="wrap_content"
        android:ems="10"
        android:hint="To"
        android:inputType="textEmailAddress"
        app:layout_constraintBottom_toTopOf="@+id/editTextTextPersonName"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <EditText
        android:id="@+id/editTextTextPersonName2"
        android:layout_width="411dp"
        android:layout_height="wrap_content"
        android:ems="10"
        android:hint="Message"
        android:inputType="textPersonName"
        app:layout_constraintBottom_toTopOf="@+id/button"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/editTextTextPersonName" />

    <EditText
        android:id="@+id/editTextTextPersonName"
        android:layout_width="411dp"
        android:layout_height="wrap_content"
        android:ems="10"
        android:hint="Subject"
        android:inputType="textPersonName"
        app:layout_constraintBottom_toTopOf="@+id/editTextTextPersonName2"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/editTextTextEmailAddress" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Send"
        app:layout_constraintBottom_toTopOf="@+id/guideline"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.879"
        app:layout_constraintStart_toStartOf="parent" />

    <androidx.constraintlayout.widget.Guideline
        android:id="@+id/guideline"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        app:layout_constraintGuide_begin="215dp" />
</androidx.constraintlayout.widget.ConstraintLayout>
```
Can you now add a TextView and write “Message sent” when the user press the send button.

**Exercise 2: Apply for Job Design**

Open a new project and design Apply activity as the following figure 2 below. 


![image](uploads/be2f12f38a16dd62277ab86db74eabaf/image.png)

Figure 3: Apply for job design.

**Final XML code** 

**Note: don’t copy and paste the code, just use it as a guide to your design.**  

```xml
?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <EditText
        android:id="@+id/editTextTextPersonName3"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:ems="10"
        android:hint="First Name"
        android:inputType="textPersonName"
        app:layout_constraintEnd_toStartOf="@+id/editTextTextPersonName4"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <EditText
        android:id="@+id/editTextTextPersonName4"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:ems="10"
        android:hint="Last Name"
        android:inputType="textPersonName"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toEndOf="@+id/editTextTextPersonName3"
        app:layout_constraintTop_toTopOf="parent" />

    <EditText
        android:id="@+id/editTextTextPersonName5"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:ems="10"
        android:hint="Date of Birth"
        android:inputType="textPersonName"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/editTextTextPersonName3" />

    <EditText
        android:id="@+id/editTextTextPersonName6"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:ems="10"
        android:hint="Country"
        android:inputType="textPersonName"
        app:layout_constraintEnd_toStartOf="@+id/button2"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/editTextTextPersonName5" />

    <Button
        android:id="@+id/button2"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:text="Apply"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toEndOf="@+id/editTextTextPersonName6"
        app:layout_constraintTop_toBottomOf="@+id/editTextTextPersonName5" />
</androidx.constraintlayout.widget.ConstraintLayout>
```
**Can you make the app interactive?**


**Exercise 3: Design your MakeitClean app**

Start thinking about your UI layout for your app and test the layout using the layout validation.

**Exercise 4: Use Git in Android Studio**

Working with Git in Android is quite easy and it need only a few steps, if you use a Mac machine, then the following [Medium article](https://betterprogramming.pub/how-to-use-git-in-android-studio-part-1-a8a554006aad) is for you. If you use a VM or Windows machine, then the only difference is the first step to go to File ➤ Settings ➤ Version Control ➤ Git instead of Preferences. The rest will be the same.

**Happy design time**
