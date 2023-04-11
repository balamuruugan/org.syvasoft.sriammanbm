--DROP VIEW TF_UOM_V;

CREATE OR REPLACE VIEW TF_UOM_V AS

SELECT 
	row_number() OVER (ORDER BY u.C_UOM_ID ) TF_UOM_V_ID, o.AD_client_ID, o.AD_Org_ID, 
	u.IsActive, u.created, u.updated,
	u.Createdby, u.Updatedby,
	u.C_UOM_ID,
	u.X12DE355, u.UOMSymbol,
	u.Name,
	c.M_Product_ID,
	(SELECT p.Name FROM M_Product p WHERE c.M_Product_ID = p.M_Product_ID ) ProductName,
	c.C_UOM_TO_ID,
	(SELECT u1.Name From C_UOM u1 WHERE u1.C_UOM_ID = c.C_UOM_TO_ID) To_UOM,
	c.dividerate
FROM 
	C_UOM u LEFT OUTER JOIN C_UOM_Conversion c
	 ON u.C_UOM_ID = c.C_UOM_ID 
	CROSS JOIN AD_Org o
WHERE 
	u.AD_Client_ID  IN (0,1000000) AND o.AD_Client_ID = 1000000 AND
	o.AD_Org_ID > 0 AND u.UOMType = 'WE' 

;