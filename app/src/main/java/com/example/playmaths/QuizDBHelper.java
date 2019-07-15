package com.example.playmaths;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.playmaths.QuizContract.*;

import java.util.ArrayList;
import java.util.List;

public class QuizDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MyAwesomeQuiz.db";
    private static final int DATABASE_VERSION = 1;

    private static QuizDBHelper instance;
    private SQLiteDatabase db;

    public QuizDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized QuizDBHelper getInstance(Context context) {
        if (instance == null) {
            instance = new QuizDBHelper(context.getApplicationContext());
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_CATEGORIES_TABLE = "CREATE TABLE " +
                CategoriesTable.TABLE_NAME + "( " +
                CategoriesTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CategoriesTable.COLUMN_NAME + " TEXT " +
                ")";

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER, " +
                QuestionsTable.COLUMN_DIFFICULTY + " TEXT, " +
                QuestionsTable.COLUMN_CATEGORY_ID + " INTEGER, " +
                "FOREIGN KEY(" + QuestionsTable.COLUMN_CATEGORY_ID + ") REFERENCES " +
                CategoriesTable.TABLE_NAME + "(" + CategoriesTable._ID + ")" + "ON DELETE CASCADE" +
                ")";


        db.execSQL(SQL_CREATE_CATEGORIES_TABLE);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillCategoriesTable();
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CategoriesTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    private void fillCategoriesTable() {
        Category c1 = new Category("Addition");
        insertCategory(c1);
        Category c2 = new Category("Subtraction");
        insertCategory(c2);
        Category c3 = new Category("Multiplication");
        insertCategory(c3);
        Category c4 = new Category("Division");
        insertCategory(c4);
    }

    public void addCategory(Category category) {
        db = getWritableDatabase();
        insertCategory(category);
    }

    public void addCategories(List<Category> categories) {
        db = getWritableDatabase();

        for (Category category : categories) {
            insertCategory(category);
        }
    }


    private void insertCategory(Category category) {
        ContentValues cv = new ContentValues();
        cv.put(CategoriesTable.COLUMN_NAME, category.getName());
        db.insert(CategoriesTable.TABLE_NAME, null, cv);
    }

    private void fillQuestionsTable() {
        Questions q1 = new Questions(" 1 + 2 ",
                "3", "5", "13", 1, Questions.DIFFICULTY_EASY, Category.ADDITION);
        insertQuestion(q1);
        Questions q2 = new Questions(" 5 + 3 ",
                "4", "8", "10", 2, Questions.DIFFICULTY_EASY, Category.ADDITION);
        insertQuestion(q2);
        Questions q3 = new Questions(" 10 + 3 ",
                "19", "18", "13", 3, Questions.DIFFICULTY_EASY, Category.ADDITION);
        insertQuestion(q3);
        Questions q4 = new Questions(" 2 + 12 ",
                "14", "35", "42", 1, Questions.DIFFICULTY_EASY, Category.ADDITION);
        insertQuestion(q4);
        Questions q5 = new Questions(" 12 + 9 ",
                "18", "21", "31", 2, Questions.DIFFICULTY_EASY, Category.ADDITION);
        insertQuestion(q5);
        Questions q6 = new Questions(" 24 + 22 ",
                "46", "45", "43", 1, Questions.DIFFICULTY_MEDIUM, Category.ADDITION);
        insertQuestion(q6);
        Questions q7 = new Questions(" 48 + 51 ",
                "98", "99", "94", 2, Questions.DIFFICULTY_MEDIUM, Category.ADDITION);
        insertQuestion(q7);
        Questions q8 = new Questions(" 15 + 33 ",
                "38", "26", "48", 3,Questions.DIFFICULTY_MEDIUM, Category.ADDITION);
        insertQuestion(q8);
        Questions q9 = new Questions(" 27 + 53 ",
                "80", "95", "70", 1, Questions.DIFFICULTY_MEDIUM, Category.ADDITION);
        insertQuestion(q9);
        Questions q10 = new Questions(" 11 + 91 ",
                "82", "102", "101", 2, Questions.DIFFICULTY_MEDIUM, Category.ADDITION);
        insertQuestion(q10);
        Questions q11 = new Questions(" 221 + 222 ",
                "443", "445", "412", 1, Questions.DIFFICULTY_HARD, Category.ADDITION);
        insertQuestion(q11);
        Questions q12 = new Questions(" 322 + 450 ",
                "609", "772", "813", 2,Questions.DIFFICULTY_HARD, Category.ADDITION);
        insertQuestion(q12);
        Questions q13 = new Questions(" 145 + 462 ",
                "628", "617", "607", 3, Questions.DIFFICULTY_HARD, Category.ADDITION);
        insertQuestion(q13);
        Questions q14 = new Questions(" 723 + 130 ",
                "853", "751", "562", 1, Questions.DIFFICULTY_HARD, Category.ADDITION);
        insertQuestion(q14);
        Questions q15 = new Questions(" 515 + 389 ",
                "918", "904", "914", 2, Questions.DIFFICULTY_HARD, Category.ADDITION);
        insertQuestion(q15);
        Questions q16 = new Questions(" 5 - 2 " ,
                "3", "5", "13", 1, Questions.DIFFICULTY_EASY, Category.SUBTRACTION);
        insertQuestion(q16);
        Questions q17 = new Questions(" 5 - 3 ",
                "4", "2", "1", 2, Questions.DIFFICULTY_EASY, Category.SUBTRACTION);
        insertQuestion(q17);
        Questions q18 = new Questions(" 10 - 3 ",
                "9", "8", "7", 3, Questions.DIFFICULTY_EASY, Category.SUBTRACTION);
        insertQuestion(q18);
        Questions q19 = new Questions(" 22 - 12 ",
                "10", "15", "8", 1, Questions.DIFFICULTY_EASY, Category.SUBTRACTION);
        insertQuestion(q19);
        Questions q20 = new Questions(" 12 - 9 ",
                "8", "3", "2", 2, Questions.DIFFICULTY_EASY, Category.SUBTRACTION);
        insertQuestion(q20);
        Questions q21 = new Questions(" 24 - 13 ",
                "9", "19", "37", 1, Questions.DIFFICULTY_MEDIUM, Category.SUBTRACTION);
        insertQuestion(q21);
        Questions q22 = new Questions(" 88 - 31 ",
                "58", "57", "64", 2, Questions.DIFFICULTY_MEDIUM, Category.SUBTRACTION);
        insertQuestion(q22);
        Questions q23 = new Questions(" 95 - 13 ",
                "68", "86", "82", 3,Questions.DIFFICULTY_MEDIUM, Category.SUBTRACTION);
        insertQuestion(q23);
        Questions q24 = new Questions(" 77 - 23 ",
                "54", "95", "70", 1, Questions.DIFFICULTY_MEDIUM, Category.SUBTRACTION);
        insertQuestion(q24);
        Questions q25 = new Questions(" 91 - 24 ",
                "87", "67", "61", 2, Questions.DIFFICULTY_MEDIUM, Category.SUBTRACTION);
        insertQuestion(q25);
        Questions q26 = new Questions(" 567 - 242 ",
                "325", "346", "415", 1, Questions.DIFFICULTY_HARD, Category.SUBTRACTION);
        insertQuestion(q26);
        Questions q27 = new Questions(" 1322 - 550 ",
                "609", "772", "813", 2,Questions.DIFFICULTY_HARD, Category.SUBTRACTION);
        insertQuestion(q27);
        Questions q28 = new Questions(" 1145 - 462 ",
                "628", "617", "683", 3, Questions.DIFFICULTY_HARD, Category.SUBTRACTION);
        insertQuestion(q28);
        Questions q29 = new Questions(" 2723 - 1593 ",
                "q29", "751", "562", 1, Questions.DIFFICULTY_HARD, Category.SUBTRACTION);
        insertQuestion(q29);
        Questions q30 = new Questions(" 2515 - 1389 ",
                "918", "1126", "914", 2, Questions.DIFFICULTY_HARD, Category.SUBTRACTION);
        insertQuestion(q30);
        Questions q31 = new Questions(" 1 * 2 ",
                "3", "5", "13", 1, Questions.DIFFICULTY_EASY, Category.MULTIPLICATION);
        insertQuestion(q31);
        Questions q32 = new Questions(" 5 * 3 ",
                "14", "15", "10", 2, Questions.DIFFICULTY_EASY, Category.MULTIPLICATION);
        insertQuestion(q32);
        Questions q33 = new Questions(" 10 * 3 ",
                "29", "28", "30", 3, Questions.DIFFICULTY_EASY, Category.MULTIPLICATION);
        insertQuestion(q33);
        Questions q34 = new Questions(" 2 * 12 ",
                "24", "25", "22", 1, Questions.DIFFICULTY_EASY, Category.MULTIPLICATION);
        insertQuestion(q34);
        Questions q35 = new Questions(" 12 * 9 ",
                "118", "108", "111", 2, Questions.DIFFICULTY_EASY, Category.MULTIPLICATION);
        insertQuestion(q35);
        Questions q36 = new Questions(" 24 * 22 ",
                "528", "545", "543", 1, Questions.DIFFICULTY_MEDIUM, Category.MULTIPLICATION);
        insertQuestion(q36);
        Questions q37 = new Questions(" 48 * 15 ",
                "698", "720", "694", 2, Questions.DIFFICULTY_MEDIUM, Category.MULTIPLICATION);
        insertQuestion(q37);
        Questions q38 = new Questions(" 15 * 33 ",
                "438", "426", "495", 3,Questions.DIFFICULTY_MEDIUM, Category.MULTIPLICATION);
        insertQuestion(q38);
        Questions q39 = new Questions(" 27 * 53 ",
                "1431", "1195", "1270", 1, Questions.DIFFICULTY_MEDIUM, Category.MULTIPLICATION);
        insertQuestion(q39);
        Questions q40 = new Questions(" 11 * 91 ",
                "1082", "1001", "1011", 2, Questions.DIFFICULTY_MEDIUM, Category.MULTIPLICATION);
        insertQuestion(q40);
        Questions q41 = new Questions(" 100 * 16 ",
                "1600", "1700", "1650", 1, Questions.DIFFICULTY_HARD, Category.MULTIPLICATION);
        insertQuestion(q41);
        Questions q42 = new Questions(" 150 * 20 ",
                "3500", "3000" , "3200", 2,Questions.DIFFICULTY_HARD, Category.MULTIPLICATION);
        insertQuestion(q42);
        Questions q43 = new Questions(" 15 * 50 ",
                "650", "700", "750", 3, Questions.DIFFICULTY_HARD, Category.MULTIPLICATION);
        insertQuestion(q43);
        Questions q44 = new Questions(" 70 * 5 ",
                "350", "450", "550", 1, Questions.DIFFICULTY_HARD, Category.MULTIPLICATION);
        insertQuestion(q44);
        Questions q45 = new Questions(" 50 * 35 ",
                "1650", "1750", "1700", 2, Questions.DIFFICULTY_HARD, Category.MULTIPLICATION);
        insertQuestion(q45);
        Questions q46 = new Questions(" 6 / 2 " ,
                "3", "5", "13", 1, Questions.DIFFICULTY_EASY, Category.DIVISION);
        insertQuestion(q46);
        Questions q47 = new Questions(" 12 / 3 ",
                "4", "4", "1", 2, Questions.DIFFICULTY_EASY, Category.DIVISION);
        insertQuestion(q47);
        Questions q48 = new Questions(" 20 / 5 ",
                "9", "8", "4", 3, Questions.DIFFICULTY_EASY, Category.DIVISION);
        insertQuestion(q48);
        Questions q49 = new Questions(" 22 / 11 ",
                "11", "15", "8", 1, Questions.DIFFICULTY_EASY, Category.DIVISION);
        insertQuestion(q49);
        Questions q50 = new Questions(" 21 / 9 ",
                "8", "3", "12", 2, Questions.DIFFICULTY_EASY, Category.DIVISION);
        insertQuestion(q50);
        Questions q51 = new Questions(" 288 / 12 ",
                "24", "19", "37", 1, Questions.DIFFICULTY_MEDIUM, Category.DIVISION);
        insertQuestion(q51);
        Questions q52 = new Questions(" 204 / 6 ",
                "58", "34", "64", 2, Questions.DIFFICULTY_MEDIUM, Category.DIVISION);
        insertQuestion(q52);
        Questions q53 = new Questions(" 285 / 15 ",
                "18", "16", "19", 3,Questions.DIFFICULTY_MEDIUM, Category.DIVISION);
        insertQuestion(q53);
        Questions q54 = new Questions(" 161 / 23 ",
                "7", "15", "17", 1, Questions.DIFFICULTY_MEDIUM, Category.DIVISION);
        insertQuestion(q54);
        Questions q55 = new Questions(" 255 / 17 ",
                "17", "15", "16", 2, Questions.DIFFICULTY_MEDIUM, Category.DIVISION);
        insertQuestion(q55);
        Questions q56 = new Questions(" 1210 / 242 ",
                "5", "6", "4", 1, Questions.DIFFICULTY_HARD, Category.DIVISION);
        insertQuestion(q56);
        Questions q57 = new Questions(" 3300 / 550 ",
                "7", "6", "8", 2,Questions.DIFFICULTY_HARD, Category.DIVISION);
        insertQuestion(q57);
        Questions q58 = new Questions(" 1140 / 30 ",
                "36", "37", "38", 3, Questions.DIFFICULTY_HARD, Category.DIVISION);
        insertQuestion(q58);
        Questions q59 = new Questions(" 2750 / 55 ",
                "50", "75", "55", 1, Questions.DIFFICULTY_HARD, Category.DIVISION);
        insertQuestion(q59);
        Questions q60 = new Questions(" 1125 / 25 ",
                "40", "45", "55", 2, Questions.DIFFICULTY_HARD, Category.DIVISION);
        insertQuestion(q60);

    }

    public void addQuestion(Questions question) {
        db = getWritableDatabase();
        insertQuestion(question);
    }

    public void addQuestions(List<Questions> questions) {
        db = getWritableDatabase();

        for (Questions question : questions) {
            insertQuestion(question);
        }
    }

    private void insertQuestion(Questions question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        cv.put(QuestionsTable.COLUMN_DIFFICULTY, question.getDifficulty());
        cv.put(QuestionsTable.COLUMN_CATEGORY_ID, question.getCategoryID());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    public List<Category> getAllCategories() {
        List<Category> categoryList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + CategoriesTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Category category = new Category();
                category.setId(c.getInt(c.getColumnIndex(CategoriesTable._ID)));
                category.setName(c.getString(c.getColumnIndex(CategoriesTable.COLUMN_NAME)));
                categoryList.add(category);
            } while (c.moveToNext());
        }

        c.close();
        return categoryList;
    }

    public ArrayList<Questions> getAllQuestions() {
        ArrayList<Questions> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Questions question = new Questions();
                question.setId(c.getInt(c.getColumnIndex(QuestionsTable._ID)));
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));
                question.setCategoryID(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_CATEGORY_ID)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

    public ArrayList<Questions> getQuestions(int categoryID, String difficulty) {
        ArrayList<Questions> questionList = new ArrayList<>();
        db = getReadableDatabase();

        String selection = QuestionsTable.COLUMN_CATEGORY_ID + " = ? " +
                " AND " + QuestionsTable.COLUMN_DIFFICULTY + " = ? ";
        String[] selectionArgs = new String[]{String.valueOf(categoryID), difficulty};

        Cursor c = db.query(
                QuestionsTable.TABLE_NAME,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        if (c.moveToFirst()) {
            do {
                Questions question = new Questions();
                question.setId(c.getInt(c.getColumnIndex(QuestionsTable._ID)));
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));
                question.setCategoryID(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_CATEGORY_ID)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }
}