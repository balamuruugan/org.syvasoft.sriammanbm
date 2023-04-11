
CREATE OR REPLACE VIEW TF_YardLoadEntry_Summary 
AS
SELECT 
	(row_number() over (order by now(), vt.Name, l.Createdby))::numeric  TF_YardLoadEntry_Summary_ID, l.DateAcct, vt.Name , COUNT(*) || ' Load' Description,
	l.AD_Client_ID, l.AD_Org_ID,l.Createdby, 
	now() created, l.Createdby updatedby, now() updated, 'Y'::CHARACTER(1) isactive
FROM
	TF_YardLoadEntry l INNER JOIN TF_VehicleType vt
	 ON l.TF_VehicleType_ID = vt.TF_VehicleType_ID
WHERE
	l.DocStatus = 'CO'  AND DATE_TRUNC('day',l.DateAcct)=DATE_TRUNC('day',now())
GROUP BY
	l.AD_Client_ID, l.AD_Org_ID, l.DateAcct, l.Createdby, vt.Name


UNION

SELECT 
	(row_number() over (order by now(), l.Createdby))::numeric  + 9999  TF_YardLoadEntry_Summary_ID, l.DateAcct, 'X Bck' VehicleType , 
	SUM(Total_Bucket - BucketPerLoad) || ' Qty' Description,
	l.AD_Client_ID, l.AD_Org_ID, l.Createdby, 
	now() created, l.Createdby updatedby, now() updated, 'Y'::CHARACTER(1) isactive
FROM
	TF_YardLoadEntry l 
WHERE
	l.DocStatus = 'CO' AND DATE_TRUNC('day',l.DateAcct)=DATE_TRUNC('day',now())
GROUP BY
	l.AD_Client_ID, l.AD_Org_ID, l.DateAcct, l.Createdby
	
ORDER BY 2,3
	
;
