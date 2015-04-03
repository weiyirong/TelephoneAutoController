package com.example.telactivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SettingActivity extends Activity implements OnClickListener {
	EditText normalNum1, normalNum2;
	EditText abnormalNum1, abnormalNum2;
	Button btn1_save, btn1_reset, btn2_save, btn2_reset;
	private SharedPreferences sp;

	String normalNum1Str, normalNum2Str;
	String abnormalNum1Str, abnormalNum2Str;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting);
		findView();
	}

	private void findView() {
		// TODO Auto-generated method stub
		normalNum1 = (EditText) findViewById(R.id.normalNumber1);
		normalNum2 = (EditText) findViewById(R.id.normalNumber2);
		abnormalNum1 = (EditText) findViewById(R.id.abnormalNum1);
		abnormalNum2 = (EditText) findViewById(R.id.abnormalNum2);
		btn1_save = (Button) findViewById(R.id.btn1_save);
		btn1_reset = (Button) findViewById(R.id.btn1_reset);
		btn2_save = (Button) findViewById(R.id.btn2_save);
		btn2_reset = (Button) findViewById(R.id.btn2_reset);

		btn1_save.setOnClickListener(this);
		btn1_reset.setOnClickListener(this);
		btn2_reset.setOnClickListener(this);
		btn2_save.setOnClickListener(this);

		sp = getSharedPreferences("SettingActivity", MODE_PRIVATE);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn1_save:
			normalNum1Str = normalNum1.getText().toString();
			abnormalNum1Str = abnormalNum1.getText().toString();
			if (normalNum1Str == null || normalNum1Str.trim().equals("")) {
				Toast.makeText(this, "原始号码不能为空", Toast.LENGTH_SHORT).show();
				return;
			}
			if (abnormalNum1Str == null || abnormalNum1Str.trim().equals("")) {
				Toast.makeText(this, "欲显示号码不能为空", Toast.LENGTH_SHORT).show();
				return;
			}
			put(normalNum1Str, abnormalNum1Str);
			break;
		case R.id.btn1_reset:
			normalNum1Str = normalNum1.getText().toString();
			if (normalNum1Str == null || normalNum1Str.trim().equals("")) {
				Toast.makeText(this, "原始号码不能为空", Toast.LENGTH_SHORT).show();
				return;
			}
			put(normalNum1Str, null);
			break;
		case R.id.btn2_reset:
			normalNum2Str = normalNum2.getText().toString();
			if (normalNum2Str == null || normalNum2Str.trim().equals("")) {
				Toast.makeText(this, "原始号码不能为空", Toast.LENGTH_SHORT).show();
				return;
			}
			put(normalNum2Str, null);
			break;
		case R.id.btn2_save:
			normalNum2Str = normalNum2.getText().toString();
			abnormalNum2Str = abnormalNum2.getText().toString();
			if (normalNum2Str == null || normalNum2Str.trim().equals("")) {
				Toast.makeText(this, "原始号码不能为空", Toast.LENGTH_SHORT).show();
				return;
			}
			if (abnormalNum2Str == null || abnormalNum2Str.trim().equals("")) {
				Toast.makeText(this, "欲显示号码不能为空", Toast.LENGTH_SHORT).show();
				return;
			}
			put(normalNum2Str, abnormalNum2Str);
			break;
		}
	}

	public void put(String key, String value) {
		Editor edit = sp.edit();
		edit.putString(key, value);
		edit.commit();
		Toast.makeText(this, "操作成功", Toast.LENGTH_SHORT).show();
		finish();
	}
}
