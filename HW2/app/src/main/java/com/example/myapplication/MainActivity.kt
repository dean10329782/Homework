package bluenet.com.MyApplication2

import android.R
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_item)
        //連結畫面元件
        //『猜拳』按鈕點擊監聽
        btn_mora.setOnClickListener(View.OnClickListener { v: View? ->
            //判斷使用者是否輸入姓名
            if (ed_name.length() < 1) tv_text.setText("請輸入玩家姓名") else {
                //顯示使用者姓名、出拳
                tv_name.setText(String.format("名字\n%s", ed_name.getText().toString()))
                if (btn_scissor.isChecked()) tv_mmora.setText("我方出拳\n剪刀") else if (btn_stone.isChecked()) tv_mmora.setText(
                    "我方出拳\n石頭"
                ) else tv_mmora.setText("我方出拳\n布")
                //使用亂數產生電腦出拳
                val computer = (Math.random() * 3).toInt()
                if (computer == 0) tv_cmora.setText("電腦出拳\n剪刀") else if (computer == 1) tv_cmora.setText(
                    "電腦出拳\n石頭"
                ) else tv_cmora.setText("電腦出拳\n布")
                //判斷勝負
                if (btn_scissor.isChecked() && computer == 2 || btn_stone.isChecked() && computer == 0 ||
                    btn_paper.isChecked() && computer == 1
                ) {
                    tv_winner.setText(String.format("勝利者\n%s", ed_name.getText()))
                    tv_text.setText("恭喜你獲勝了！！！")
                } else if (btn_scissor.isChecked() && computer == 1 || btn_stone.isChecked() && computer == 2 ||
                    btn_paper.isChecked() && computer == 0
                ) {
                    tv_winner.setText("勝利者\n電腦")
                    tv_text.setText("可惜，電腦獲勝了！")
                } else {
                    tv_winner.setText("勝利者\n平手")
                    tv_text.setText("平局，請再試一次！")
                }
            }
        })
    }
}