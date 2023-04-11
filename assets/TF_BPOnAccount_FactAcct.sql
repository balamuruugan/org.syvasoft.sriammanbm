
CREATE OR REPLACE VIEW TF_BPOnAccount_FactAcct AS


SELECT 
	i.AD_Client_ID, i.AD_Org_ID, i.IsActive, 
	i.Created, i.Createdby, i.Updated, i.Updatedby,
	i.DateAcct, i.DocumentNo,
	i.C_BPartner_ID, i.GrandTotal Debit, 0 Credit
	
FROM
	TF_TaxInvoice i

WHERE
	i.DocStatus = 'CO'

UNION

SELECT
	p.AD_Client_ID, p.AD_Org_ID, p.IsActive,
	p.Created, p.Createdby, p.Updated, p.Updatedby,
	p.DateAcct, p.DocumentNo2, 
	p.C_BPartner_ID, CASE WHEN p.IsReceipt = 'N' THEN p.PayAmt ELSE NULL END Debit,
	CASE WHEN p.IsReceipt = 'Y' THEN p.PayAmt ELSE 0 END Credit
FROM
	C_Payment p
WHERE	
	p.OnAccount='Y' AND p.C_BPartner_ID IS NOT NULL 
	AND p.DocStatus IN ('CO','CL')

;
