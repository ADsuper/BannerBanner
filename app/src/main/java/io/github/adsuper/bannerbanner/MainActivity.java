package io.github.adsuper.bannerbanner;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.banner)
    Banner mBanner;

    private List<Integer> mList = new ArrayList();
    private List<String> mList1 = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initBannerView();
    }

    private void initBannerView() {


        Integer[] images = {R.drawable.gril, R.drawable.gril1, R.drawable.gril2, R.drawable.gril3, R.drawable.gril4};
        String[] titles = {"美女1", "美女2", "美女3", "美女4", "美女5"};

        mList.add(R.drawable.gril);
        mList.add(R.drawable.gril1);
        mList.add(R.drawable.gril2);
        mList.add(R.drawable.gril3);
        mList.add(R.drawable.gril4);

        mList1.add("美女1");
        mList1.add("美女2");
        mList1.add("美女3");
        mList1.add("美女4");
        mList1.add("美女5");
        //设置指示器的显示位置
        mBanner.setIndicatorGravity(BannerConfig.RIGHT);
        //设置点击事件
        mBanner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int i) {
                Toast.makeText(getApplicationContext(), i + "", Toast.LENGTH_SHORT).show();
            }
        });
        //设置 banner 样式
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置切换动画
        mBanner.setBannerAnimation(Transformer.DepthPage);
        //设置图片加载方式
        mBanner.setImageLoader(new GlideImageloader());
        //设置图片资源
        mBanner.setImages(mList);
        //设置文字数据
        mBanner.setBannerTitles(mList1);
        //完成设置
        mBanner.start();

    }

    public class GlideImageloader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Log.i("mBanner", path.toString());
            Glide.with(context).load(path).fitCenter().into(imageView);
        }

    }
}
