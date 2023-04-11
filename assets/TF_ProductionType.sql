SELECT * FROM TF_ProductionTypeList_V
CREATE OR REPLACE VIEW TF_ProductionTypeList_V AS 

SELECT row_number() over (ORDER BY ProductionType) TF_ProductionTypeList_V_ID,* FROM

(SELECT 
	DISTINCT	
	pp.TF_ProductionPlant_ID,
	pp.Name ProductionPlant,
	pc.AD_Org_ID,
	pc.AD_Client_ID,
	'Y'::character(1) IsActive,
	now() Created, pc.CreatedBy,
	now() Updated, pc.UpdatedBy,
	pc.TF_BlueMetal_Type ProductionType,
	(SELECT r.Name FROM AD_Ref_List r WHERE  r.AD_Reference_ID=1000107 AND r.Value = pc.TF_BlueMetal_Type)
	ProductionTypeDesc
	
FROM 
	TF_CrusherProduction_Config pc INNER JOIN TF_ProductionPlant pp
	  ON pp.TF_ProductionPlant_ID = pc.TF_ProductionPlant_ID
WHERE
	pc.IsActive = 'Y'
ORDER BY
	ProductionType ) AS A;