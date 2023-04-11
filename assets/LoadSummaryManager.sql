
CREATE OR REPLACE VIEW TF_YardLoadEntry_Manager 
AS
SELECT 
	(row_number() over (order by now(), l.AD_Org_ID, vt.Name))::numeric  TF_YardLoadEntry_Manager_ID, 
	l.DateAcct, MAX(o.Value) || ', ' ||  vt.Name "name" , COUNT(*) || ' Load' Description,
	l.AD_Client_ID, l.AD_Org_ID, 0 Createdby, 
	now() created, 0 updatedby, now() updated, 'Y'::CHARACTER(1) isactive
FROM
	TF_YardLoadEntry l INNER JOIN TF_VehicleType vt
	 ON l.TF_VehicleType_ID = vt.TF_VehicleType_ID
	INNER JOIN AD_Org o
	 ON l.AD_Org_ID = o.AD_Org_ID
WHERE
	l.DocStatus = 'CO'  AND DATE_TRUNC('day',l.DateAcct)=DATE_TRUNC('day',now())
GROUP BY
	l.AD_Client_ID, l.AD_Org_ID, l.DateAcct, vt.Name


UNION

SELECT 
	(row_number() over (order by now(), l.AD_Org_ID))::numeric  + 9999  TF_YardLoadEntry_Manager_ID, l.DateAcct, 
	MAX(o.Value) ||  ', X Bck' VehicleType , 
	SUM(Total_Bucket - BucketPerLoad) || ' Qty' Description,
	l.AD_Client_ID, l.AD_Org_ID, 0 Createdby, 
	now() created, 0 updatedby, now() updated, 'Y'::CHARACTER(1) isactive
FROM
	TF_YardLoadEntry l INNER JOIN AD_Org o
	 ON o.AD_Org_ID = l.AD_Org_ID
WHERE
	l.DocStatus = 'CO' AND DATE_TRUNC('day',l.DateAcct)=DATE_TRUNC('day',now())
GROUP BY
	l.AD_Client_ID, l.AD_Org_ID, l.DateAcct
	
ORDER BY 2,3
	
;
