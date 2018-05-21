package com.example.scout_zong.dialog;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Window;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.scout_zong.hotelreservationsystem1_0.R;
import com.example.scout_zong.tool.Tool;

import java.util.Calendar;

/**
 * Created by scout_zong on 2018/4/11.
 */

public class BookDialog extends BaseDialog  implements  DatePicker.OnDateChangedListener{
    private Context context;
    private DatePicker datePicker;
    private Tool mTool;
    public static int BOOK_TAG=0;
    private int yearOfYear,monthOfYear,dayOfMonth,numberDay,startDay,endDay;
    public BookDialog(@NonNull Context context) {
        super(context);
        this.context=context;

    }
    public BookDialog(@NonNull Context context,Tool tool) {
        super(context);
        this.context=context;
        this.mTool=tool;
    }

    @Override
    protected void SettingViewDialog() {
        super.SettingViewDialog();
        setContentView(R.layout.book_dialog_layout);
        setCancelable(true);
        datePicker=findViewById(R.id.datePicker);
        Calendar calendar = Calendar.getInstance();
        yearOfYear=calendar.get(Calendar.YEAR);
        monthOfYear=calendar.get(Calendar.MONTH);
//        monthOfYear=monthOfYear+1;
        dayOfMonth=calendar.get(Calendar.DAY_OF_MONTH);
        datePicker.init(yearOfYear,monthOfYear,dayOfMonth,this);
        if (BOOK_TAG==1)
        mTool.setStartTime(yearOfYear+"年"+monthOfYear+"月"+dayOfMonth+"日");
        if (BOOK_TAG==2)
        mTool.setEndTime(yearOfYear+"年"+monthOfYear+"月"+dayOfMonth+"日");


    }

    @Override
    public void onDateChanged(DatePicker datePicker, int year, int month, int day) {

           if (BOOK_TAG==1) {
               monthOfYear=month+1;
               mTool.setStartTime(yearOfYear + "年" + monthOfYear + "月" + day + "日");
               startDay=day;
           }
           if(BOOK_TAG==2) {
               mTool.setEndTime(yearOfYear + "年" + monthOfYear + "月" + day + "日");
               Log.e("BookDialog---------->", year + "年" + monthOfYear + "月" + day + "日" + BOOK_TAG);
               endDay=day;
           }
           mTool.setNumberDay(endDay-startDay);


    }



}
