SELECT *  FROM

( SELECT
	i.C_Invoice_ID, 
	o.Name OrgName,
	(SELECT 
		l.Address1 || COALESCE(E'\n' || l.Address2 || ',' ,'') ||
		COALESCE(E'\n' || l.Address3 || ',' ,'') ||
		COALESCE(E'\n' || l.Address4 || ',' ,'') ||
		COALESCE(E'\n' || l.City || ',' ,'') ||
		COALESCE(E'\nPincode: ' || l.Postal || ',','') ||
		COALESCE(E'\n' || l.RegionName || '.','')
	 FROM 
		C_Location l 		
	  WHERE 
	  	info.C_Location_ID = l.C_Location_ID )
	OrgAddress,
	info.Phone OrgPhone,
	
	i.DocumentNo,
	i.DateAcct,
	bp.Name Customer,
	bp.Address1 || COALESCE(E'\n' || bp.Address2 || ',' ,'') ||
	COALESCE(E'\n' || bp.Address3 || ',' ,'') ||
	COALESCE(E'\n' || bp.Address4 || ',' ,'') ||
	COALESCE(E'\n' || bp.City || ',' ,'') ||
	COALESCE(E'\nPincode: ' || bp.Postal || ',','') ||
	COALESCE(E'\n' || bp.RegionName || '.','') ||
	COALESCE(E'\nContact No: ' || bp.Phone,'') 
	CustomerAddress,
	i.vehicleno,
	(SELECT Name FROM TF_Destination WHERE TF_Destination_ID = (
	 SELECT TF_Destination_ID FROM C_Order WHERE C_Order_ID = 1002150  ))
	Destination
	
FROM 
	C_Invoice i INNER JOIN AD_Org o
	 ON o.AD_Org_ID = i.AD_Org_ID
	INNER JOIN C_BPartner bp
	 ON i.C_BPartner_ID = bp.C_BPartner_ID
	INNER JOIN AD_OrgInfo info
	 ON i.AD_Org_ID = info.AD_Org_ID
	
	
WHERE 
	i.C_Invoice_ID = (SELECT MAX(C_Invoice_ID) FROM C_Invoice WHERE C_Order_ID =  1002150 
	AND i.DocStatus IN ('CO','CL')) 
) h, (SELECT 1 col UNION SELECT 2 col) AS h2 

---
--DETAIL
---


SELECT
	p.Name Item,  il.Description, il.QtyInvoiced Qty, u.Name UOM
FROM
	C_InvoiceLine il INNER JOIN M_Product p
	 ON il.M_Product_ID = p.M_Product_ID
	INNER JOIN C_UOM u
	 ON u.C_UOM_ID = il.C_UOM_ID	

WHERE 	
	il.C_Invoice_ID = 1004794



