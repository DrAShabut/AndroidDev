**About This Tutorial**


![image](uploads/7e766148270fd32ad121f48164e0b921/image.png)

Android is an open-source mobile operating system based on Java language and Linux kernel. It runs on different handheld mobile devices such as smartphones, tablets, switches, TV, etc. Android was developed by Android Inc. and is now led by Google which purchased it in 2005. This tutorial will illustrate the basics of Android development through “Hello World” and “Change me” examples. To be satisfied with this material, please review the introductory lecture notes. 

**What You'll Learn:**

After finishing this tutorial, you'll be familiar with some Android words. You'll also be able to start a new project, create basic designs, write simple code, and run your app on a real or virtual device.

**What You Need:**

You'll need some space on your computer to install Android Studio if you want to use your own. If you have an Android device, grab a USB cable to connect it to your computer. It's faster to test your apps on a real device than a virtual one. Don't worry if you don't have your own; you can ask the LTU Media Centre to lend you a tablet for the semester. Let's get started!

**Hello World Example**

1. Install Android Studio 
For guidance on installing Android Studio, exploring its features, and understanding how to use it, visit https://developer.android.com/studio/?utm_source=android-studio. This link offers access to the latest stable version, with Android Studio 2023.1.1 being the most recent version during the creation of this tutorial. Keep in mind that there might be slight variations between your screens and the tutorial's content as it is based on an older version 4.0.1 but it will be the same steps.

2. After installing Android Studio, you will have the following screen: 

![image](uploads/40df356643d45955a55a3cce54b5b1da/image.png)

3. Press on the ‘Create New Project’ option and the following screen will appear:

![image](uploads/7bdd6780cd6584fc6e0019f346e96e97/image.png) 

4. Keep the default selections as we will develop apps for “Phone and Tablet” and we will select an “Empty Activity” to start our project with, (for Hedgehog version, select Empty Views Activity' to develop with Java language, press Next when you are ready and the following screen will appear:

![image](uploads/247fc797596a0f4b4788f604980aefa8/image.png) 

5. Change the name of the project to “MyFirstApplication” and the language to Java instead of Kotlin. Select the project location and keep the default value for the package and the minimum SDK.

- _It is preferred to keep all the examples in one folder and name it “Android App Development”._ 

6. Click Finish to see your app created with an Activity (Java-based file) called MainActivity and a Layout (XML-based file) called activity_main. If your project is created successfully, you will see the following project screen:

![image](uploads/252b9f3d0766cd65243d9e0abecaed5e/image.png) 

_**Now you are ready to run your application**_

7. Click the Run menu and select Run ‘app’ command according to the following screen:

![image](uploads/f9a3f5fca79d652746708a8e3d81fd7d/image.png)
 
8. Select the deployment target (i.e. where do you want to run your app) by creating a virtual device or connecting a real device.
  
You will see an error message “**No target device found**” at this stage as there is "**No Device**" yet to run your app. Click "**No Device**" and then click "**Open AVD Manager**". You will see a screen similar to the following:

![image](uploads/8b2a92467ba7daefe7ff9fabd43d8dbd/image.png)

Click “**Create New Virtual Device**” and follow the complete steps in the following link to create your own virtual device: [Create and manage virtual devices  |  Android Developers](https://developer.android.com/studio/run/managing-avds). If you successfully created a virtual device, you will see a screen similar to the following: 

![image](uploads/1014300ff0057525938b05cde4fb1e4c/image.png)
 
For this test, I connected my Samsung Galaxy S7 and the screen below shows the detected device. To connect your device, you need to activate the DEVELOPER OPTIONS and USB debugging from the device settings. The following link will provide you with detailed information to connect your real device: Run apps on a hardware device  |  Android Developers.
By allowing access to your device, you will have the following screen:

![image](uploads/b1aa61b172bcc6449ed4c4ec0109e153/image.png)
 
9. Now select the connected device and click the OK button. The run process will start as in the screen below:

![image](uploads/f5e942fb0d724ae01a364e4093479b2c/image.png)
 
This process may take a long time to finish and it can take longer if you use a virtual device. 
Well done you have created your first ‘Hello World’ app.
 
**Now time for coding…**
 

**Change Me Example**

1. Expand the app files on the left-hand side and then expand the ‘res’ folder, scroll down to the layout folder and expand it, click on ‘activity_main.xml’ and  the UI design will be shown on your screen as follows:

![image](uploads/3db1ea9be98d32c056b5a2b7a8d2d237/image.png) 

- Now you can be creative and design your UI.
 
2. Delete the ‘Hello World!’ TextView by clicking it and then pressing ‘delete’ button from your keyboard. 

3. From the palette (in the above screen) where all Widgets are available, add a TextView and a Button to your project by clicking, dragging and dropping on the activity design in the required location. The design will look like the following screen:

![image](uploads/6a5460f15298a043473edea6ee3bcb96/image.png) 

4. Click the Button as in the screen above and change the ID on the right-hand side to ‘firstButton’ and create an event on the onClick option named ‘pressMeButton’. 

![image](uploads/44707980dd1a4006db555a76e060accb/image.png)
 
5. Click on the Code tab at the top right of the screen above and the xml code will appear as follow: 

![image](uploads/b133c6cb485ab1ce7c7e4d6a8663c154/image.png)
 
6. Move the pointer to the ‘pressMeButton’ event and a small help light bulb will appear. Press on the option ‘Create ‘pressMeButton(View)’ in ‘MainActivity’’ option as in the screen below:

![image](uploads/83c2d8abd6a1398246463aa6bd3f569d/image.png)
  
7. A public method called ‘pressMeButton’ is created in the ‘MainActivity’ as in the screen below:

![image](uploads/95e2b3a9887012ed251421345de7e5ea/image.png)
 
- Now we need to write our code inside this method.


**Change Me idea is very simple for now:**

If we press the button we want the text in the TextView to be changed to “Find a great idea for the next app”. 

8. To do so, define two variables to match the two types of views as below:

![image](uploads/a351c23e84d2616155b72c299afb91a1/image.png)

9. The two variables are in red colour which means more classes are required to be imported by the system. To resolve this click Alt + Enter and click Import class.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pressMeButton(View view) {
    }
 
- Now everything is fine, let's continue coding:
 
10. Add the following code inside the method onCreate() to find the views by their IDs. The onCreate() method is one of many methods that are fired when an activity is loaded.  
 
11. Now write the following code in the pressMeButton() method.
 
The code will look like this in the MainActivity.java.
 
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newText = findViewById(R.id.textView);
        changeButton = findViewById(R.id.firstButton);
    }

    public void pressMeButton(View view) {
        newText.setText("Find a great idea for the next app");
    }

12. Add a layout constraint to your UI design by connecting the views to the parent. Change the text of the TextView to “change me” and the text of pressMeButton to “Click me”.
 
The xml code in the activity_main.xml will look like the following: 

     <Button
        android:id="@+id/firstButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="157dp"
        android:layout_marginLeft="157dp"
        android:layout_marginEnd="166dp"
        android:layout_marginRight="166dp"
        android:layout_marginBottom="374dp"
        android:onClick="pressMeButton"
        android:text="Button"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent" />

     <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="172dp"
        android:layout_marginLeft="172dp"
        android:layout_marginTop="93dp"
        android:layout_marginEnd="181dp"
        android:layout_marginRight="181dp"
        android:layout_marginBottom="196dp"
        android:text="TextView"
        app:layout_constraintBottom_toTopOf="@+id/firstButton"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
 
13. Let us run the app again, remember to click on the Run list and press Run app command. You will have the following screens:
 
![image](uploads/5a96782ae204d167d44bb6543fb436ee/image.png)

**What’s Next**

To strengthen your grasp of Android fundamentals and expand your dev toolkit, it's recommended to explore Chapter 1 in the book "Head First Android Development, 3rd Edition," accessible at oreilly.com. Note: Although this book primarily uses Kotlin as the programming language, Chapter 1 is comprehensive and covers everything necessary to commence Android development.

Exercise 1: Develop a simple calculator using Android Studio. 
(Note: this needs to be submitted with the first example).
![image](https://github.com/DrAShabut/AndroidDev/assets/146723487/5542a98b-b56d-4fb5-a035-d55d32dc55f2)
Here is the blueprint to know the names of views.
![image](https://github.com/DrAShabut/AndroidDev/assets/146723487/58c0cdd3-28de-483c-b288-74a8c0585288)

