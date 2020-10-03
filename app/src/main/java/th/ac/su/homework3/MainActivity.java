package th.ac.su.homework3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import th.ac.su.homework3.model.WordItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);

        // สร้าง Adapter object
        MyAdapter adapter = new MyAdapter();
        // สร้าง Layout manager
        LinearLayoutManager lm = new LinearLayoutManager(MainActivity.this);

        // เข้าถึง RecyclerView ใน layout
        RecyclerView rv = findViewById(R.id.word_list_recycler_view);
        rv.setLayoutManager(lm); // กำหนด layout manager ให้กับ RecyclerView
        rv.setAdapter(adapter); // กำหนด Adapter ให้กับ RecyclerView
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        WordItem[] items = {
                new WordItem(R.drawable.chanyeol,"Park Chan Yeol","ปาร์ค ชาน ยอล"),
                new WordItem(R.drawable.suho,"Kim Jun Myun","คิม จุน มยอน"),
                new WordItem(R.drawable.xiumin,"Kim Min Seok","คิม มินซอก"),
                new WordItem(R.drawable.lay,"Zhang Yixing","จาง อี้ชิง"),
                new WordItem(R.drawable.beakhyun,"Byun Baek Hyun","พยอน แบค ฮยอน"),
                new WordItem(R.drawable.chen,"Kim Jong Dae","คิม จง แด"),
                new WordItem(R.drawable.soo,"Do Kyung Soo","โด คยอง ซู"),
                new WordItem(R.drawable.kai,"Kim Jong In","คิม จง อิน"),
                new WordItem(R.drawable.sehun,"Oh Se Hun","โอ เซ ฮุน"),
                new WordItem(R.drawable.kris,"Wu Yifan","อู๋ อี้ฝาน"),
                new WordItem(R.drawable.luhan,"Luhan","ลู่หาน"),
                new WordItem(R.drawable.tao,"Huang Zitao","หวง จื่อเทา"),
        };
        // WordItem item2;

        public MyAdapter(){
            /*item = new WordItem(R.drawable.cat,"CAT");
            item2 = new WordItem(R.drawable.dog,"DOG");*/

        }
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_word, parent, false);
            MyViewHolder vh = new MyViewHolder(v);
            return vh;

        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.imageView.setImageResource(items[position].imageResId);
            holder.wordTextView.setText(items[position].word);
            holder.wordTextView2.setText(items[position].word2);


        }


        public int getItemCount(){
            // return 10;
            return items.length;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;
            TextView wordTextView;
            TextView wordTextView2;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.image_view);
                wordTextView = itemView.findViewById(R.id.word_text_view);
                wordTextView2 = itemView.findViewById(R.id.word_text_view2);
            }
        }
    }

}
