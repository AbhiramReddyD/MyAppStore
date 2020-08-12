package com.abhi.groupdata;

import android.content.Intent;
import android.graphics.Movie;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {


    private List<News> newsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private NewsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent	=	getIntent();
        setContentView(R.layout.activity_main2);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new NewsAdapter(newsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);



        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                String s[]={
                       "https://techknowspace.wordpress.com/2018/08/31/huawei-kirin-980-worlds-first-7nm-commercial-chipset-big-threat-to-snapdragon/",
                        "https://techknowspace.wordpress.com/2018/08/08/hacker-leaks-snapchat-source-code-on-github/",
                        "https://techknowspace.wordpress.com/2018/08/06/whatsapp-soon-to-monetize/",
                        "https://techknowspace.wordpress.com/2018/11/28/no-dont-buy-a-new-phone-now/",
                        "https://techknowspace.wordpress.com/2018/10/13/hackers-attack-fb-check-if-youre-on-the-list/\n",
                        "https://techknowspace.wordpress.com/2018/09/18/one-plus-working-on-an-affordable-smart-tv/",
                        "https://techknowspace.wordpress.com/2018/09/11/what-is-tensorflow-for-machine-learning/",
                        "https://techknowspace.wordpress.com/2018/09/04/mis-poco-five-minute-sale-%e2%82%b9200-crores-3m/",
                        "https://techknowspace.wordpress.com/2018/08/31/sony-xperia-xz3-first-impressions/",
                        "https://techknowspace.wordpress.com/2018/10/23/ios-12-1-will-improve-selfie-quality-on-the-iphone-xs-and-xr/"
                };
                String m = s[1];
                switch (position)
                {
                    case 0:m=s[0];
                    break;
                    case 1:m=s[1];
                        break;
                    case 2:m=s[2];
                        break;
                    case 3:m=s[3];
                        break;
                    case 4:m=s[4];
                        break;
                    case 5:m=s[5];
                        break;
                    case 6:m=s[6];
                        break;
                    case 7:m=s[7];
                        break;
                    case 8:m=s[8];
                        break;
                    case 9:m=s[9];
                        break;

                }
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(m));
                startActivity(browserIntent);
                News news = newsList.get(position);
                Toast.makeText(getApplicationContext(), news.getTitle() + " ", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        prepareNewsData();
        }

    private void prepareNewsData() {
        News news = new News(R.drawable.huawei,"Huawei Kirin 980 World’s first 7nm commercial Chipset BIG THREAT to Snapdragon", "Yes finally 7nm chips are on the move,\n" +
                "As we know Huawei specially manufacture their own processors for their devices ,");
        newsList.add(news);
         news = new News(R.drawable.snapchat,"Hacker leaks Snapchat Source-Code on GitHub", "A hacker seems to be from Pakistan allegedly leaks the source code of Snapchat in GitHub");
        newsList.add(news);
        news = new News(R.drawable.wats,"WhatsApp Soon To Monetize", "For Starters,Facebook bought WhatsApp  for about $19 billion, Back then it was a Big Deal!! even for the Social Giant. At that time, WhatsApp had about 450 million monthly active users and 315 million daily active users, according to Business Insider.");
        newsList.add(news);
        news = new News(R.drawable.ios,"No Don’t buy a new Phone Now…..", "Yes you heard it right , Just consider this before you buy  a new phone now Firstly the new phones are indeed rich in features but they cost a fortune to you and for God’s sake those screens cost a fortune for you.. I mean seriously unlike the previous models we can’t just replace the […]\n");
        newsList.add(news);
        news = new News(R.drawable.fb,"Hackers attack FB, Check if your’e on the list.", "Yes, what you heard is true ,this isn’t some old news or fake news . Facebook disclosed this two weeks ago. Facebook.Inc said sensitive information regarding search or location information and other info such as hometown etc.Frankly speaking this is a big blow for Facebook after considering the recent situations it’s clear that this Mega");
        newsList.add(news);
        news = new News(R.drawable.oneplus,"One Plus soon to launch an affordable Smart TV.", "Yes , you heard it right this flagship killers are in-fact soon to launch an affordable Smart TV ,maybe called  ” One Plus TV  “soon and it might disrupt the TV  industry.Well it was nothing new for us to hear Chinese smartphone manufacturers stepping in to launch TV’s like Xiaomi has launched Mi TV and […]");
        newsList.add(news);
        news =new News(R.drawable.tf,"What is TensorFlow for Machine Learning","TensorFlow™ is an open source software library(Developed by Google Brain Team) For high performance numerical computation. Its has a flexible architecture allows easy deployment of computation across a variety of platforms (CPUs, GPUs, TPUs),Central Processing Unit,Graphical Processing Unit,Tensor Processing Unit as defined bu google. From desktops to clusters of servers to mobile and edge devices. Originally […]");
        newsList.add(news);
        news =new News(R.drawable.poco,"MI’s POCO Five Minute Sale ₹200 crores ($3M)","“Biggest and Fastest Flagship Sale ever on Flipkart.” Mi’s subbrand POCO F1’s first sale was a whooping sucess,According to Xiaomi tehy sold over ₹200 crores in 5 minutes this was the biggest sale not only over Flipkart but proboably on all platforms. There are also many cashback offers upto ₹1000 but using HDFC payments and many more.The […]");
        newsList.add(news);
        news =new News(R.drawable.sony,"Sony Xperia XZ3 First Impressionsa","At a press conference held at the ongoing IFA electronics trade show in Berlin, Sony announced a bunch of new products across multiple categories. One of them was its new Xperia XZ3 smartphone, which succeeds the Xperia XZ2 that launched earlier this year. The company hasn’t announced any pricing details yet, but says its latest flagship phone will");
        newsList.add(news);
        news =new News(R.drawable.ios,"iOS 12.1 will improve selfie quality on the iPhone XS and XR","Whatever the case, it was definitely there, but now it’s going away: during our iPhone XR review, Apple told me that iOS 12.1 will fix a bug in its smart HDR camera system that resulted in smoother-looking photos taken by the front camera on the iPhone XS and XR. Essentially, Smart HDR was choosing the […]a");
        newsList.add(news);
        mAdapter.notifyDataSetChanged();
    }
}



