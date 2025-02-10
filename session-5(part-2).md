**About the Tutorial**

![image](uploads/7e766148270fd32ad121f48164e0b921/image.png)

# Creating and using Room API database

In this exercise, we're going to demonstrate working with Room API. As you're already familiar with SQL and SQLite databases, then much of what you know will apply. 

Step 1: Add Dependencies
First, add the Room dependencies to your build.gradle (Module: app) file:

```xml
dependencies {
    implementation("androidx.room:room-runtime:2.5.2")
    annotationProcessor("androidx.room:room-compiler:2.5.2")
}
```
Step 2: Create the User Entity
This class defines the table structure.

```java
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)  // Auto-increments ID
    public int uid;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;

    // Constructor
    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
```
Step 3: Create UserDao (Data Access Object)
This interface defines methods for interacting with the database.

```java
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insertAll(User... users);  // Insert multiple users

    @Query("SELECT * FROM User")  // Fetch all users
    List<User> getAllUsers();
}
```
Step 4: Create AppDatabase (Room Database Class)
This is the main database class that initializes Room.

```java
import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    private static volatile AppDatabase INSTANCE;

    // Singleton to prevent multiple instances
    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "user-database")
                            .allowMainThreadQueries() // Not recommended for large apps
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
```
Step 5: Use Room Database in an Activity
This activity inserts and retrieves user data.

```java
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private AppDatabase db;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize database
        db = AppDatabase.getInstance(this);
        userDao = db.userDao();

        // Insert users into the database
        User user1 = new User("Alice", "Brown");
        User user2 = new User("Bob", "Smith");

        userDao.insertAll(user1, user2);
        Log.d(TAG, "Users inserted!");

        // Fetch all users and log them
        List<User> users = userDao.getAllUsers();
        for (User user : users) {
            Log.d(TAG, "User: " + user.uid + ", " + user.firstName + " " + user.lastName);
        }
    }
}
```
Step 6: AndroidManifest.xml Permissions
Add the android.permission.INTERNET permission if needed, though Room doesn't require extra permissions:

```xml
<uses-permission android:name="android.permission.INTERNET"/>
```
Expected Log Output (Android Logcat)
```makefile
Users inserted!
User: 1, Alice Brown
User: 2, Bob Smith
```

![image](https://github.com/user-attachments/assets/3492899b-3454-4b25-934f-c8546fa4d9e6)

Step 7: Now add UI elements and show the results in a list view or text view.


