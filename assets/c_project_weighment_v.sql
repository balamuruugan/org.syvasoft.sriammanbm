-- View: c_project_weighment_v

-- DROP VIEW c_project_weighment_v;

CREATE OR REPLACE VIEW c_project_weighment_v AS 
 SELECT pr.ad_client_id,
    pr.ad_org_id,
    pr.c_project_id,
    pr.isactive,
    pr.created,
    pr.createdby,
    pr.updated,
    pr.updatedby,
    pr.c_project_uu,
    pr.documentno,
    pr.name AS subcontractname,
    bp.c_bpartner_id,
    bp.name AS bpname,
    pr.c_bpartner_location_id,
    pr.c_paymentterm_id,
    pt.name AS paymentterm,
    pr.c_currency_id,
    cur.iso_code,
    pr.poreference,
    pr.description,
    pr.jobwork_product_id,
    pd.name AS jobworkname,
    pr.c_uom_id,
    u.name AS uom_name,
    pr.unit_price,
    pr.docstatus,
    pr.processed,
    pr.SubcontractType,
    pr.M_Warehouse_ID
   FROM c_project pr
     JOIN c_bpartner bp ON pr.c_bpartner_id = bp.c_bpartner_id
     JOIN c_paymentterm pt ON pt.c_paymentterm_id = pr.c_paymentterm_id
     JOIN c_currency cur ON cur.c_currency_id = pr.c_currency_id
     LEFT JOIN m_product pd ON pd.m_product_id = pr.jobwork_product_id
     JOIN c_uom u ON u.c_uom_id = pr.c_uom_id
  ;

ALTER TABLE c_project_weighment_v
  OWNER TO adempiere;
