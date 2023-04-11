-- View: tf_cashbookreport_trans_v

-- DROP VIEW tf_cashbookreport_trans_v;

CREATE OR REPLACE VIEW tf_cashbookreport_trans_v AS 
 SELECT p.ad_client_id,
    p.ad_org_id,
    p.isactive,
    p.created,
    p.createdby,
    p.updated,
    p.updatedby,
    p.c_payment_id,
    p.c_bankaccount_id,
    p.dateacct,
    p.documentno,
        CASE
            WHEN p.fromto_bankaccount_id IS NOT NULL THEN (( SELECT (b.accountno::text || ' '::text) || c_1.name::text
               FROM c_bankaccount b
                 JOIN c_bank c_1 ON b.c_bank_id = c_1.c_bank_id
              WHERE b.c_bankaccount_id = p.fromto_bankaccount_id))::character varying
            WHEN (EXISTS ( SELECT p.c_elementvalue_id
               FROM tf_glposting_config
              WHERE p.c_elementvalue_id = tf_glposting_config.salarypayable_acct OR p.c_elementvalue_id = tf_glposting_config.salariesadvanceacct_id)) THEN bp.name
            WHEN p.c_elementvalue_id IS NOT NULL THEN c.name
            WHEN bp.isposcashbp = 'Y'::bpchar AND p.isreceipt = 'Y'::bpchar THEN 'Cash Sales'::character varying || COALESCE(' - ' || pc.Name,'')
            WHEN bp.isposcashbp = 'Y'::bpchar AND p.isreceipt = 'N'::bpchar THEN 'Cash Purchase'::character varying || COALESCE(' - ' || pc.Name,'')
            ELSE bp.name
        END AS accounthead,
        CASE
            WHEN p.c_invoice_id IS NOT NULL AND p.isreceipt = 'Y'::bpchar THEN 'Sales Invoice : '::text || i.documentno::text
            WHEN p.c_invoice_id IS NOT NULL AND p.isreceipt = 'N'::bpchar THEN 'Purchase Invoice : '::text || i.documentno::text
            ELSE ''::text
        END || COALESCE(' '::text || p.description::text, ''::text) AS description,
        CASE
            WHEN p.isreceipt = 'Y'::bpchar THEN p.payamt
            ELSE NULL::numeric
        END AS receipt,
        CASE
            WHEN p.isreceipt = 'N'::bpchar THEN p.payamt
            ELSE NULL::numeric
        END AS payment
   FROM c_payment p
     JOIN c_bpartner bp ON bp.c_bpartner_id = p.c_bpartner_id
     LEFT JOIN c_charge c ON c.c_charge_id = p.c_charge_id
     LEFT JOIN c_invoice i ON i.c_invoice_id = p.c_invoice_id
     LEFT JOIN c_project pr ON pr.c_project_id = p.c_project_id
     LEFT JOIN c_elementvalue e ON e.c_elementvalue_id = p.user1_id
     LEFT JOIN c_order o ON i.c_order_id = o.c_order_id
     LEFT JOIN m_product p1 ON p1.M_Product_ID = o.Item1_ID
     LEFT JOIN M_Product_Category pc ON p1.M_Product_Category_ID = pc.M_Product_Category_ID
  WHERE p.docstatus = ANY (ARRAY['CO'::bpchar, 'CL'::bpchar])
  ORDER BY p.ad_org_id, p.c_bankaccount_id, p.datetrx;
