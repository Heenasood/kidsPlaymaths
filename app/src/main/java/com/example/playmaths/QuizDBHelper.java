package com.example.playmaths;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.playmaths.QuizContract.*;

import java.util.ArrayList;

public class QuizDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyAwesomeQuiz.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public QuizDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable() {
        Questions q1 = new Questions(" 1 + 2 ", "3", "5", "13", 1);
        addQuestion(q1);
        Questions q2 = new Questions(" 9 + 3 ", "6", "12", "3", 2);
        addQuestion(q2);
        Questions q3 = new Questions(" 5 + 3 ", "1", "0", "8", 3);
        addQuestion(q3);
        Questions q4 = new Questions(" 7 + 2 ", "9", "5", "2", 1);
        addQuestion(q4);
        Questions q5 = new Questions(" 1 + 9 ", "8", "10", "11", 2);
        addQuestion(q5);
        Questions q6 = new Questions(" 1 + 2 ", "3", "5", "13", 1);
        addQuestion(q6);
        Questions q7 = new Questions(" 9 + 3 ", "6", "12", "3", 2);
        addQuestion(q7);
        Questions q8 = new Questions(" 5 + 3 ", "1", "0", "8", 3);
        addQuestion(q8);
        Questions q9 = new Questions(" 7 + 2 ", "9", "5", "2", 1);
        addQuestion(q9);
        Questions q10 = new Questions(" 1 + 9 ", "8", "10", "11", 2);
        addQuestion(q10);
        Questions q11 = new Questions(" 1 + 2 ", "3", "5", "13", 1);
        addQuestion(q11);
        Questions q12 = new Questions(" 2 + 3 ", "6", "5", "3", 2);
        addQuestion(q12);
        Questions q13 = new Questions(" 5 + 2 ", "8", "0", "7", 3);
        addQuestion(q13);
        Questions q14 = new Questions(" 3 + 0 ", "3", "5", "2", 1);
        addQuestion(q14);
        Questions q15 = new Questions(" 5 + 9 ", "8", "14", "11", 2);
        addQuestion(q15);
    }

    private void addQuestion(Questions question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    public ArrayList<Questions> getAllQuestions() {
        ArrayList<Questions> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Questions question = new Questions();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }
}