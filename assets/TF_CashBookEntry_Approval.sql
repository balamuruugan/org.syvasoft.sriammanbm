--DROP VIEW TF_CashBookEntry_Approval ;
CREATE OR REPLACE VIEW TF_CashBookEntry_Approval AS
SELECT
	p.AD_Client_ID, p.AD_Org_ID, p.IsActive, p.Created,p.CreatedBy,p.Updated,p.Updatedby,
	(SELECT COALESCE(ShortName, Value) FROM AD_Org o WHERE o.AD_Org_ID = p.AD_Org_ID) AS Org ,
	p.C_Payment_ID,
	p.C_BankAccount_ID,
	p.DateAcct,
	p.DocumentNo,
		
	CASE
	 WHEN p.FromTo_BankAccount_ID IS NOT NULL THEN 
		(SELECT b.AccountNo || ' ' || c.Name FROM C_BankAccount b INNER JOIN C_Bank c ON b.C_Bank_ID = c.C_Bank_ID
		WHERE b.C_BankAccount_ID = p.FromTo_BankAccount_ID)
	 WHEN EXISTS(SELECT p.C_ElementValue_ID FROM TF_GLPosting_Config WHERE p.C_ElementValue_ID IN 
		(SalaryPayable_Acct, SalariesAdvanceAcct_ID)) THEN bp.Name
	 WHEN p.C_ElementValue_ID IS NOT NULL THEN c.Name
	 WHEN bp.IsPOSCashBP='Y' AND p.IsReceipt='Y' THEN 'Cash Sales'
	 WHEN bp.IsPOSCashBP='Y' AND p.IsReceipt='N' THEN 'Cash Purchase'
	 ELSE bp.Name
	END AccountHead,

	CASE 
	 WHEN p.C_Invoice_ID IS NOT NULL AND p.IsReceipt='Y' THEN 'Sales Invoice : ' || i.DocumentNo 
	 WHEN p.C_Invoice_ID IS NOT NULL AND p.IsReceipt='N' THEN 'Purchase Invoice : ' || i.DocumentNo 
	 ELSE '' 
	END || COALESCE(' ' || p.Description,'') Description,
	CASE
	 WHEN p.IsReceipt = 'Y' THEN PayAmt
	 ELSE NULL
	END Receipt,
	CASE
	 WHEN p.IsReceipt = 'N' THEN PayAmt
	 ELSE NULL
	END Payment
	
FROM
	C_Payment p 
	INNER JOIN C_BPartner bp
	 ON bp.C_BPartner_ID = p.C_BPartner_ID
	LEFT OUTER JOIN C_Charge c
	 ON c.C_Charge_ID = p.C_Charge_ID
	LEFT OUTER JOIN C_Invoice i
	 ON i.C_Invoice_ID = p.C_Invoice_ID
	LEFT OUTER JOIN C_Project pr
	 ON pr.C_Project_ID = p.C_Project_ID
	LEFT OUTER JOIN C_ElementValue e
	 ON e.C_ElementValue_ID = p.User1_ID
WHERE
	p.DocStatus = 'IP' AND p.Ref_Payment_ID IS NOT NULL
ORDER BY
	p.AD_Org_ID, p.C_BankAccount_ID, p.DateTrx;
;