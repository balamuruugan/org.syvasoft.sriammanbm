
CREATE OR REPLACE VIEW TF_YardPermitIssue_Manager 
AS

SELECT 
	(row_number() over (order by now(), p.AD_Org_ID, vt.Name))::numeric   TF_YardPermitIssue_Manager_ID, p.DateAcct,
	MAX(o.Value) || ', ' || vt.Name "name", 
	SUM(CASE WHEN PermitIssue_Type = 'I' THEN 1 ELSE 0 END)  || ' Issued, ' ||
	SUM(CASE WHEN PermitIssue_Type = 'C' THEN 1 ELSE 0 END)  || ' Cancelled'
	Description,
	p.AD_Client_ID, p.AD_Org_ID, 0 Createdby, 
	now() created, 0 updatedby, now() updated, 'Y'::CHARACTER(1) isactive
FROM
	TF_YardPermitIssue_Entry p INNER JOIN TF_VehicleType vt
	 ON p.TF_VehicleType_ID = vt.TF_VehicleType_ID
	INNER JOIN AD_Org o
	 ON o.AD_Org_ID = p.AD_Org_ID
WHERE
	p.DocStatus = 'CO' AND DATE_TRUNC('day',p.DateAcct)=DATE_TRUNC('day',now())
GROUP BY
	p.AD_Client_ID, p.AD_Org_ID, p.DateAcct, vt.Name

ORDER BY 2,3;