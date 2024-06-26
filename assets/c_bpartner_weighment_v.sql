﻿-- View: c_bpartner_weighment_v

 DROP VIEW c_bpartner_weighment_v;

CREATE OR REPLACE VIEW c_bpartner_weighment_v AS 
 SELECT bp.c_bpartner_id,
    bp.ad_client_id,
    bp.ad_org_id,
    bp.isactive,
    bp.created,
    bp.createdby,
    bp.updated,
    bp.updatedby,
    bp.value,
    bp.name,
    bp.name2,
    bp.description,
    bp.issummary,
    bp.c_bp_group_id,
    bp.isonetime,
    bp.isprospect,
    bp.isvendor,
    bp.iscustomer,
    bp.isemployee,
    bp.issalesrep,
    bp.referenceno,
    bp.duns,
    bp.url,
    bp.ad_language,
    bp.taxid,
    bp.istaxexempt,
    bp.c_invoiceschedule_id,
    bp.rating,
    bp.salesvolume,
    bp.numberemployees,
    bp.naics,
    bp.firstsale,
    bp.acqusitioncost,
    bp.potentiallifetimevalue,
    bp.actuallifetimevalue,
    bp.shareofcustomer,
    bp.paymentrule,
    bp.so_creditlimit,
    bp.so_creditused,
    bp.c_paymentterm_id,
    bp.m_pricelist_id,
    bp.m_discountschema_id,
    bp.c_dunning_id,
    bp.isdiscountprinted,
    bp.so_description,
    bp.poreference,
    bp.paymentrulepo,
    bp.po_pricelist_id,
    bp.po_discountschema_id,
    bp.po_paymentterm_id,
    bp.documentcopies,
    bp.c_greeting_id,
    bp.invoicerule,
    bp.deliveryrule,
    bp.freightcostrule,
    bp.deliveryviarule,
    bp.salesrep_id,
    bp.sendemail,
    bp.bpartner_parent_id,
    bp.invoice_printformat_id,
    bp.socreditstatus,
    bp.shelflifeminpct,
    bp.ad_orgbp_id,
    bp.flatdiscount,
    bp.totalopenbalance,
    bp.dunninggrace,
    bp.c_taxgroup_id,
    bp.logo_id,
    bp.ispotaxexempt,
    bp.ismanufacturer,
    bp.c_bpartner_uu,
    bp.customerprofileid,
    bp.default1099box_id,
    bp.is1099vendor,
    bp.issubcontractor,
    bp.isposcashbp,
    bp.setopeningbalance,
    bp.c_invoice_id,
    bp.address1,
    bp.address2,
    bp.address3,
    bp.address4,
    bp.city,
    bp.postal,
    bp.regionname,
    bp.c_country_id,
    bp.c_location_id,
    bp.contactname,
    bp.phone,
    bp.ad_user_id,
    bp.careof,
    bpg.name AS bpartner_group
   FROM c_bpartner bp
     JOIN c_bp_group bpg ON bp.c_bp_group_id = bpg.c_bp_group_id
  WHERE bp.isactive = 'Y'::bpchar AND TRUNC(bp.UPDATED) >= now() - 7;

ALTER TABLE c_bpartner_weighment_v
  OWNER TO adempiere;
