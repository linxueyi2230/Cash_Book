package star.liuwen.com.cash_books.Dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import star.liuwen.com.cash_books.Base.App;
import star.liuwen.com.cash_books.Base.Config;
import star.liuwen.com.cash_books.bean.ChoiceAccount;
import star.liuwen.com.cash_books.bean.ChoiceAccountDao;

/**
 * Created by liuwen on 2017/2/27.
 */
public class DaoChoiceAccount {


    /**
     * 插入对象数据
     * 插入对象为ChoiceAccount
     *
     * @param model
     */
    public static void insertChoiceAccount(ChoiceAccount model) {
        App.getDaoInstant().getChoiceAccountDao().insert(model);
    }

    /**
     * 删除对象为
     *ChoiceAccount
     * @param model
     */
    public static void deleteChoiceAccountByModel(ChoiceAccount model) {
        App.getDaoInstant().getChoiceAccountDao().delete(model);
    }


    /**
     * 删除所有
     */
    public static void deleteAllData() {
        App.getDaoInstant().getChoiceAccountDao().deleteAll();
    }


    /**
     * 更新数据
     *
     * @param model
     */
    public static void updateAccount(ChoiceAccount model) {
        App.getDaoInstant().getChoiceAccountDao().update(model);
    }

    /**
     * 查询 ChoiceAccount集合的对象
     * @return
     */
    public static List<ChoiceAccount> query() {
        List<ChoiceAccount> list = new ArrayList<>();
        list = App.getDaoInstant().getChoiceAccountDao().queryBuilder().list();
        Collections.sort(list, new Comparator<ChoiceAccount>() {
            @Override
            public int compare(ChoiceAccount model1, ChoiceAccount model2) {
                return model1.getTimeMinSec().compareTo(model2.getTimeMinSec());
            }
        });
        return list;
    }

     public static List<ChoiceAccount> queryByAccountType(String accountType){
          List<ChoiceAccount> list=new ArrayList<>();
         if (accountType.equals(Config.XYK)) {
             list = App.getDaoInstant().getChoiceAccountDao().queryBuilder().where(ChoiceAccountDao.Properties.MAccountType.eq(accountType)).build().list();
         } else if (accountType.equals(Config.CXK)) {
             list = App.getDaoInstant().getChoiceAccountDao().queryBuilder().where(ChoiceAccountDao.Properties.MAccountType.eq(accountType)).build().list();
         } else if (accountType.equals(Config.CASH)) {
             list = App.getDaoInstant().getChoiceAccountDao().queryBuilder().where(ChoiceAccountDao.Properties.MAccountType.eq(accountType)).build().list();
         } else if (accountType.equals(Config.ZFB)) {
             list = App.getDaoInstant().getChoiceAccountDao().queryBuilder().where(ChoiceAccountDao.Properties.MAccountType.eq(accountType)).build().list();
         } else if (accountType.equals(Config.WEIXIN)) {
             list = App.getDaoInstant().getChoiceAccountDao().queryBuilder().where(ChoiceAccountDao.Properties.MAccountType.eq(accountType)).build().list();
         }else if(accountType.equals(Config.TOUZI)){
             list = App.getDaoInstant().getChoiceAccountDao().queryBuilder().where(ChoiceAccountDao.Properties.MAccountType.eq(accountType)).build().list();
         }else if(accountType.equals(Config.CZK)){
             list = App.getDaoInstant().getChoiceAccountDao().queryBuilder().where(ChoiceAccountDao.Properties.MAccountType.eq(accountType)).build().list();
         }else if(accountType.equals(Config.INTENTACCOUNT)){
             list = App.getDaoInstant().getChoiceAccountDao().queryBuilder().where(ChoiceAccountDao.Properties.MAccountType.eq(accountType)).build().list();
         }

         Collections.sort(list, new Comparator<ChoiceAccount>() {
             @Override
             public int compare(ChoiceAccount model1, ChoiceAccount model2) {
                 return model2.getTimeMinSec().compareTo(model1.getTimeMinSec());
             }
         });
         return list;
     }

    /**
     * 获取总数
     * SaveMoneyPlanModel的总数
     *
     * @return
     */
    public static long getCount() {
        return App.getDaoInstant().getChoiceAccountDao().count();
    }


}
