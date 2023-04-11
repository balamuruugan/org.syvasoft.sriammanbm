--DROP VIEW TF_KatingEntry_Manager;

CREATE OR REPLACE VIEW TF_KatingEntry_Manager
AS
SELECT 
	(row_number() over (order by now(), k.AD_Org_ID, v.VehicleNo ))::numeric   TF_KatingEntry_Manager_ID, k.AD_Client_ID, 
	k.AD_Org_ID, k.DateAcct, 0 Createdby, 
	now() created, 0 updatedby, now() updated, 'Y'::CHARACTER(1) isactive,
	k.C_Project_ID, 
	MAX(o.Value) || ', ' ||  v.VehicleNo as name, 'Total Load: ' || COUNT(*) Description 
FROM 
	TF_KatingEntry k INNER JOIN TF_RentedVehicle v
	 ON k.TF_RentedVehicle_ID = v.TF_RentedVehicle_ID
	INNER JOIN AD_Org o
	 ON k.AD_Org_ID = o.AD_Org_ID
WHERE
	k.DocStatus = 'CO' AND DATE_TRUNC('day',k.DateAcct)=DATE_TRUNC('day',now())

GROUP BY 
	k.AD_Client_ID, k.AD_Org_ID, k.DateAcct, k.C_Project_ID, v.VehicleNo

ORDER BY MAX(o.Value) || ' - ' ||  v.VehicleNo 
;