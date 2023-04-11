SELECT 
	account_id,MAX(e.Name) accountName,  sum(amtacct) balance
FROM 
	rv_fact_acct_day fa INNER JOIN C_ElementValue e
	 ON fa.Account_ID = e.C_ElementValue_ID
WHERE 
	fa.AD_Client_ID = 1000000 AND fa.AD_Org_ID = 1000000 AND fa.DateAcct <= now()

GROUP BY
	fa.account_id