package com.example.kylerdavisc196project;


import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.kylerdavisc196project.model.Assessment;
import com.example.kylerdavisc196project.model.Course;
import com.example.kylerdavisc196project.model.Mentor;
import com.example.kylerdavisc196project.model.Term;

public class MainActivity extends AppCompatActivity {
    private QueryManager QM;
    private CoordinatorLayout coordinatorLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        QM = new QueryManager(MainActivity.this);
        QM.open();
        hideShowTermList();
        QM.currentTermExists();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_generate_test_data) {
            try {
                generateTestData();
            }catch(Exception e) {
                System.out.println(e);
            }
            hideShowTermList();
            Snackbar snackbar = Snackbar.make(coordinatorLayout, "Test Data Created", Snackbar.LENGTH_SHORT);
            snackbar.show();
            return true;
        }
        if (id == R.id.action_delete_all_data) {
            try {
                QM.deleteData();
            }catch(Exception e) {
                System.out.println(e);
            }
            hideShowTermList();
            Snackbar snackbar = Snackbar.make(coordinatorLayout, "All Data Deleted", Snackbar.LENGTH_SHORT);
            snackbar.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onResume() {
        super.onResume();
        QM.open();
        hideShowTermList();
    }

    @Override
    protected void onPause() {
        super.onPause();
        QM.close();
    }
    public void hideShowTermList() {
        if(!QM.isTermEmpty()) {
            ImageButton termListButton = findViewById(R.id.termListButton);
            termListButton.setVisibility(View.VISIBLE);
        } else {
            ImageButton termListButton = findViewById(R.id.termListButton);
            termListButton.setVisibility(View.INVISIBLE);
        }
    }

    public void generateTestData() {
        Term termOne = new Term("Term 1", "2019-08-01", "2020-01-31");
        QM.insertTerm(termOne);
        Term termTwo = new Term("Term 2", "2020-02-01", "2020-07-31");
        QM.insertTerm(termTwo);
        Term termThree = new Term("Term 3", "2020-08-01", "2021-01-31");
        QM.insertTerm(termThree);

        Mentor mentorOne = new Mentor("James Smith", "123-456-1234", "james.smith@wgu.edu");
        QM.insertMentor(mentorOne);
        Mentor mentorTwo = new Mentor("Michael Smith", "123-456-1235", "michael.smith@wgu.edu");
        QM.insertMentor(mentorTwo);
        Mentor mentorThree = new Mentor("Robert Smith", "123-456-1236", "robert.smith@wgu.edu");
        QM.insertMentor(mentorThree);
        Mentor mentorFour = new Mentor("Maria Garcia", "123-456-1237", "maria.garcia@wgu.edu");
        QM.insertMentor(mentorFour);
        Mentor mentorFive = new Mentor("David Smith", "123-456-1238", "david.smith@wgu.edu");
        QM.insertMentor(mentorFive);
        Mentor mentorSix = new Mentor("Maria Rodriguez", "123-456-1239", "maria.rodriquez@wgu.edu");
        QM.insertMentor(mentorSix);
        Mentor mentorSeven = new Mentor("Mary Smith", "123-456-1241", "mary.smith@wgu.edu");
        QM.insertMentor(mentorSeven);
        Mentor mentorEight = new Mentor("Maria Hernandez", "123-456-1242", "maria.hernandez@wgu.edu");
        QM.insertMentor(mentorEight);
        Mentor mentorNine = new Mentor("James Johnson", "123-456-1243", "james.johnson@wgu.edu");
        QM.insertMentor(mentorNine);

        Course courseOne = new Course("Course 1", "Course 1 Description", "2019-08-01", "2019-09-30", 2, 1, 1);
        QM.insertCourse(courseOne);
        Course courseTwo = new Course("Course 2", "Course 2 Description", "2019-10-01", "2019-11-30", 1, 1, 2);
        QM.insertCourse(courseTwo);
        Course courseThree = new Course("Course 3", "Course 3 Description", "2019-12-01", "2020-01-31", 1, 1, 3);
        QM.insertCourse(courseThree);
        Course courseFour = new Course("Course 4", "Course 4 Description", "2020-02-01", "2020-03-31", 1, 2, 4);
        QM.insertCourse(courseFour);
        Course courseFive = new Course("Course 5", "Course 5 Description", "2020-04-01", "2020-05-31", 1, 2, 5);
        QM.insertCourse(courseFive);
        Course courseSix = new Course("Course 6", "Course 6 Description", "2020-06-01", "2020-07-31", 1, 2, 6);
        QM.insertCourse(courseSix);
        Course courseSeven = new Course("Course 7", "Course 7 Description", "2020-08-01", "2020-09-30", 1, 3, 7);
        QM.insertCourse(courseSeven);
        Course courseEight = new Course("Course 8", "Course 8 Description", "2020-10-01", "2020-11-30", 1, 3, 8);
        QM.insertCourse(courseEight);
        Course courseNine = new Course("Course 9", "Course 9 Description", "2020-12-01", "2020-01-31", 1, 3, 9);
        QM.insertCourse(courseNine);

        Assessment assessmentOne = new Assessment("Course 1 Assessment", "2019-09-30", 1, 1);
        long id = QM.insertAssessment(assessmentOne);
        System.out.println(id);
        Assessment assessmentTwo = new Assessment("Course 2 Assessment", "2019-11-30", 1, 2);
        QM.insertAssessment(assessmentTwo);
        Assessment assessmentThree = new Assessment("Course 3 Assessment", "2020-01-31", 2, 3);
        QM.insertAssessment(assessmentThree);
        Assessment assessmentFour = new Assessment("Course 4 Assessment", "2020-03-31", 1, 4);
        QM.insertAssessment(assessmentFour);
        Assessment assessmentFive = new Assessment("Course 5 Assessment", "2020-05-31", 2, 5);
        QM.insertAssessment(assessmentFive);
        Assessment assessmentSix = new Assessment("Course 6 Assessment", "2020-07-31", 2, 6);
        QM.insertAssessment(assessmentSix);
        Assessment assessmentSeven = new Assessment("Course 7 Assessment", "2020-09-30", 1, 7);
        QM.insertAssessment(assessmentSeven);
        Assessment assessmentEight = new Assessment("Course 8 Assessment", "2020-11-30", 2, 8);
        QM.insertAssessment(assessmentEight);
        Assessment assessmentNine = new Assessment("Course 9 Assessment", "2020-01-31", 1, 9);
        QM.insertAssessment(assessmentNine);

        QM.insertNote("Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                "Sem et tortor consequat id porta nibh venenatis cras sed. " +
                "Consectetur lorem donec massa sapien faucibus. " +
                "Viverra orci sagittis eu volutpat odio facilisis mauris sit amet. " +
                "A erat nam at lectus urna. Diam quis enim lobortis scelerisque. " +
                "Sit amet nisl purus in mollis nunc sed id semper. Neque vitae tempus quam pellentesque nec. " +
                "Vulputate mi sit amet mauris. Mi in nulla posuere sollicitudin aliquam ultrices sagittis orci a. " +
                "At ultrices mi tempus imperdiet. Facilisi etiam dignissim diam quis enim lobortis scelerisque fermentum. " +
                "Dui sapien eget mi proin sed libero enim sed.", 1);

        QM.insertNote("Tortor condimentum lacinia quis vel eros donec ac odio tempor. " +
                "Scelerisque viverra mauris in aliquam sem fringilla ut morbi tincidunt. " +
                "Tempor commodo ullamcorper a lacus vestibulum sed arcu. " +
                "Posuere urna nec tincidunt praesent semper feugiat nibh. " +
                "Aliquam id diam maecenas ultricies mi eget mauris pharetra. " +
                "Vitae auctor eu augue ut lectus arcu bibendum. Molestie nunc non blandit massa enim nec dui nunc. " +
                "Commodo ullamcorper a lacus vestibulum sed. Lectus urna duis convallis convallis tellus id interdum velit. " +
                "Fringilla phasellus faucibus scelerisque eleifend donec. " +
                "Integer feugiat scelerisque varius morbi enim nunc. Est ante in nibh mauris cursus mattis molestie a. " +
                "Sed vulputate mi sit amet mauris commodo.", 3);

    }
}
