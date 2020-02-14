package com.knewton.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knewton.model.DailyTransaction;
import com.knewton.repository.DailyTransactionRepository;

@Service
public class ViewProfitServicesImplements implements ViewProfitServices {
	@Autowired
	DailyTransactionRepository dailyrepository;

	private List<DailyTransaction> datetolist(Date date1, Date date2) {
		List<DailyTransaction> dl = (List<DailyTransaction>) dailyrepository.findAll();
		List<DailyTransaction> db = new ArrayList<DailyTransaction>();

		for (DailyTransaction dt : dl) {
			if (dt.getDate().equals(date1) || dt.getDate().equals(date2)
					|| (dt.getDate().after(date1) && dt.getDate().before(date2))) {
				db.add(dt);

			}
		}
		return db;
	}

	@Override
	public void ViewProfit(Date date1, Date date2) {
		// TODO Auto-generated method stub

		List<DailyTransaction> listdl = datetolist(date1, date2);
		int v1 = 0, v2 = 0, v3 = 0;
		List<DailyTransaction> result = new ArrayList<DailyTransaction>();
		for (DailyTransaction dt : listdl) {
			if (dt.getTransactionTypeId() == 2) {
				result.add(dt);
			}

			float profit = 0;
			for (DailyTransaction ds : result) {
				int q1 = 0, q2 = 0;
				float costprice = 0, cp = 0;
				for (DailyTransaction dc : listdl) {
					if (dc.getItemcomposite().getItemId() == ds.getItemcomposite().getItemId()) {
						if (dc.getTransactionTypeId() == 1) {
							costprice = dc.getActualPrice();
						} else if (dc.getTransactionTypeId() == 2) {
							cp = dc.getActualPrice();
							q1 += dc.getQuantity();

						} else  {
							q2 += dc.getQuantity();

						}
					}

				}
				profit += (q1 - q2) * (cp - costprice);
			}
			valuesProfit vp = new valuesProfit();
			vp.setAmountbuy(v1);
			vp.setQuantitybuy(v1);
			vp.setAmountsell(v2);
			vp.setQuantitysell(v2);
			vp.setAmountreturn(v3);
			vp.setQuantityreturn(v3);
			//vp.getTotalprofit(profit);
		}
	
}}