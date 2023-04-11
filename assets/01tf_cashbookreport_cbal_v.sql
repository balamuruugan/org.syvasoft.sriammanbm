--DROP VIEW TF_CashBookReport_V;
--DROP VIEW TF_CashBookReport_CBal_V;

-- bank account and day closing balance
-- SELECT * FROM TF_CashBookReport_CBal_V
CREATE OR REPLACE VIEW TF_CashBookReport_CBal_V AS

SELECT 	
p.AD_Client_ID, p.AD_Org_ID, 'Y'::character(1) IsActive, now() created, 0 createdby, now() updated, 0 updatedby,
0 C_Payment_ID, p.C_BankAccount_ID,p.DateTrx, 
	COALESCE((SELECT MIN(p1.DateTrx) FROM C_Payment p1
		WHERE p.C_BankAccount_ID=p1.C_BankAccount_ID AND p1.DateTrx > p.DateTrx AND p1.DocStatus IN ('CO','CL'))
		,p.DateTrx+1)
	NextDateTrx,
	'CLOSING BALANCE'::character varying(255) description,
	(SELECT 		
		CASE 
			WHEN COALESCE(SUM(CASE WHEN p1.IsReceipt='Y' THEN p1.PayAmt ELSE p1.PayAmt *-1 END),0)>0 THEN	
				COALESCE(SUM(CASE WHEN p1.IsReceipt='Y' THEN p1.PayAmt ELSE p1.PayAmt *-1 END),0)
			ELSE NULL
		END 
	FROM
		C_Payment p1
	WHERE p1.C_BankAccount_ID = p.C_BankAccount_ID AND p1.DocStatus IN ('CO','CL') AND p1.DateTrx <= p.DateTrx)
	Receipt,

	(SELECT 		
		CASE 
			WHEN COALESCE(SUM(CASE WHEN IsReceipt='Y' THEN PayAmt ELSE PayAmt *-1 END),0)<0 THEN	
				ABS(COALESCE(SUM(CASE WHEN IsReceipt='Y' THEN PayAmt ELSE PayAmt *-1 END),0))
			ELSE NULL
		END 
	FROM
		C_Payment p1
	WHERE p1.C_BankAccount_ID = p.C_BankAccount_ID AND p1.DocStatus IN ('CO','CL') AND p1.DateTrx <= p.DateTrx)
	
	Payment
	

FROM
	C_Payment p

WHERE 	
p.DocStatus IN ('CO','CL') 

GROUP BY AD_Client_ID, AD_Org_ID, C_BankAccount_ID, DateTrx

ORDER BY 1,2,C_BankAccount_ID,DateTrx;
