package star.liuwen.com.cash_books;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import star.liuwen.com.cash_books.Activity.IncomeAndCostActivity;
import star.liuwen.com.cash_books.Base.App;
import star.liuwen.com.cash_books.Base.BaseActivity;
import star.liuwen.com.cash_books.Fragment.CommunityFragment;
import star.liuwen.com.cash_books.Fragment.HomeFragment;
import star.liuwen.com.cash_books.Fragment.ManageMoneyFragment;
import star.liuwen.com.cash_books.Fragment.MyFragment;
import star.liuwen.com.cash_books.Fragment.ReportFragment;
import star.liuwen.com.cash_books.Fragment.WalletFragment;
import star.liuwen.com.cash_books.Utils.ToastUtils;
import star.liuwen.com.cash_books.View.tab.BarEntity;
import star.liuwen.com.cash_books.View.tab.BottomTabBar;

public class MainActivity extends BaseActivity implements BottomTabBar.OnSelectListener {
    private BottomTabBar tb;
    private List<BarEntity> bars;
    private HomeFragment homeFragment;
    private WalletFragment walletFragment;
    private ReportFragment reportFragment;
    private ManageMoneyFragment mManageMoneyFragment;
    private CommunityFragment mCommunityFragment;
    private MyFragment myFragment;
    private FragmentManager manager;
    private long firstTime = 0;


    @Override
    public int activityLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        manager = getSupportFragmentManager();
        tb = (BottomTabBar) findViewById(R.id.tb);
        tb.setManager(manager);
        tb.setOnSelectListener(this);
        bars = new ArrayList<>();
        bars.add(new BarEntity("明细", R.mipmap.shiguangzhou_lan, R.mipmap.shiguangzhou));
        bars.add(new BarEntity("钱包", R.mipmap.qianbao_lan, R.mipmap.qianbao));
        bars.add(new BarEntity("报表", R.mipmap.baobiao_lan, R.mipmap.baobiao));
        bars.add(new BarEntity("开始记账", 0, 0));
        bars.add(new BarEntity("理财", R.mipmap.zongxiaofei, R.mipmap.zhuanzhang_2));
        bars.add(new BarEntity("社区", R.mipmap.jiyibi_icon_beizhu_down, R.mipmap.jiyibi_icon_beizhu));
        bars.add(new BarEntity("我的", R.mipmap.tixing_lan, R.mipmap.tixing));
        tb.setBars(bars);

    }


//    @Override
//    protected void protectApp() {
//        ToastUtils.showToast(getApplicationContext(), "应用被回收重启流程");
//        startActivity(new Intent(this, LoadingActivity.class));
//    }

    /**
     * 因为MainActivity使用了singleTask或者singleInstance的启动模式 所以只有一个实例
     * 那么久不会重新去调用onCreate()的方法 所以便要重写onNeWIntent的方法();
     *
     * @param intent
     */
    @Override
    protected void onNewIntent(Intent intent) {
        // TODO Auto-generated method stub
        super.onNewIntent(intent);
        int id = intent.getIntExtra("id", 0);
        if (id == 1) {
            onSelect(0);
        } else if (id == 2) {
            onSelect(1);
        }
    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - firstTime > 2000) {
            ToastUtils.showToast(this, getString(R.string.press_one_exit));
            firstTime = System.currentTimeMillis();
            return;
        } else {
            App app = (App) getApplication();
            app.destroyReceiver();
            ToastUtils.removeToast();
            finish();
        }
        super.onBackPressed();
    }


    public void onClickPublish(View v) {
        startActivity(new Intent(MainActivity.this, IncomeAndCostActivity.class));
        overridePendingTransition(R.anim.anim_open, R.anim.anim_close);
    }

    @Override
    public void onSelect(int position) {
        switch (position) {
            case 0:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                }
                tb.switchContent(homeFragment);
                break;
            case 1:
                if (walletFragment == null) {
                    walletFragment = new WalletFragment();
                }
                tb.switchContent(walletFragment);
                break;
            case 2:
                if (reportFragment == null) {
                    reportFragment = new ReportFragment();
                }
                tb.switchContent(reportFragment);
                break;
            case 3:
                break;
            case 4:
                if (mManageMoneyFragment == null) {
                    mManageMoneyFragment = new ManageMoneyFragment();
                }
                tb.switchContent(mManageMoneyFragment);
                break;
            case 5:
                if (mCommunityFragment == null) {
                    mCommunityFragment = new CommunityFragment();
                }
                tb.switchContent(mCommunityFragment);
                break;
            case 6:
                if (myFragment == null) {
                    myFragment = new MyFragment();
                }
                tb.switchContent(myFragment);
                break;
            default:
                break;
        }
    }
}
