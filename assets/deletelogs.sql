delete from ad_changelog where AD_CLIENT_id >= 11;
delete from AD_session where AD_CLIENT_id >= 11 and ad_session_id NOT IN (SELECT ad_session_id from ad_changelog) ;

DELETE FROM AD_PInstance_Para where AD_CLIENT_id >= 11;
DELETE FROM AD_PInstance  where AD_CLIENT_id >= 11;