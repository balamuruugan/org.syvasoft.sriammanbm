
CREATE OR REPLACE FUNCTION amountinwords_units(unit numeric)
  RETURNS character varying  AS
$BODY$
DECLARE
	unit_name character varying;
BEGIN
	RETURN CASE unit
			 WHEN 1 THEN 'One'
			 WHEN 2 THEN 'Two'
			 WHEN 3 THEN 'Three'
			 WHEN 4 THEN 'Four'
			 WHEN 5 THEN 'Five'
			 WHEN 6 THEN 'Six'
			 WHEN 7 THEN 'Seven'
			 WHEN 8 THEN 'Eight'
			 WHEN 9 THEN 'Nine'
			 WHEN 10 THEN 'Ten'
			 WHEN 11 THEN 'Eleven'
			 WHEN 12 THEN 'Twelve'
			 WHEN 13 THEN 'Thirteen'
			 WHEN 14 THEN 'Fourteen'
			 WHEN 15 THEN 'Fifteen'
			 WHEN 16 THEN 'Sixteen'
			 WHEN 17 THEN 'Seventeen'
			 WHEN 18 THEN 'Eighteen'
			 WHEN 19 THEN 'Nineteen'
			 ELSE ''
			END ;	

END;
$BODY$
  LANGUAGE plpgsql STABLE
  COST 100;



-------------------


CREATE OR REPLACE FUNCTION amountinwords_tens(tens numeric)
  RETURNS character varying  AS
$BODY$
DECLARE
	tens_name character varying;
BEGIN
	RETURN CASE tens :: int
			 WHEN 0 THEN ''
			 WHEN 1 THEN ''
			 WHEN 2 THEN 'Twenty'
			 WHEN 3 THEN 'Thirty'
			 WHEN 4 THEN 'Forty'
			 WHEN 5 THEN 'Fifty'
			 WHEN 6 THEN 'Sixty'
			 WHEN 7 THEN 'Seventy'
			 WHEN 8 THEN 'Eighty'
			 WHEN 9 THEN 'Ninety'
			 ELSE ''			
			END ;	

END;
$BODY$
  LANGUAGE plpgsql STABLE
  COST 100;


------------------------


CREATE OR REPLACE FUNCTION amountinwords(amount numeric)
  RETURNS character varying  AS
$BODY$
DECLARE
	amtinwords character varying;
BEGIN
	IF (amount < 0) THEN
		RETURN 'Minus ' || amountinwords(amount*-1);
	ELSIF (amount < 20) THEN
		RETURN amountinwords_units(amount :: int);
	ELSIF (amount < 100) THEN
		RETURN amountinwords_tens(SUBSTR(TO_CHAR(amount,'09'), 1, 2) :: numeric) || 
			(CASE WHEN (amount % 10 != 0) THEN ' ' ELSE '' END) || amountinwords(amount % 10);
	ELSIF (amount < 1000) THEN
		RETURN amountinwords(SUBSTR(TRIM(TO_CHAR(amount,'000')), 1, 1) :: numeric) || 		
			' Hundred' || (CASE WHEN (amount % 100 != 0) THEN ' And ' ELSE '' END) || amountinwords(amount % 100);
	ELSIF (amount < 100000) THEN
		RETURN amountinwords(SUBSTR(TRIM(TO_CHAR(amount,'00999')), 1, 2) :: numeric) || 		
			' Thousand' || (CASE WHEN (amount % 1000 != 0) THEN ' ' ELSE '' END) || amountinwords(amount % 1000);
	ELSIF (amount < 10000000) THEN
		RETURN amountinwords(SUBSTR(TRIM(TO_CHAR(amount,'0099999')), 1, 2) :: numeric) || 		
			' Lakh' || (CASE WHEN (amount % 100000  != 0) THEN ' ' ELSE '' END) || amountinwords(amount % 100000);
	END IF;

	
	RETURN 
		amountinwords(SUBSTR(TRIM(TO_CHAR(amount,'099999999')), 1, 2) :: numeric) || 		
		' Crore' || (CASE WHEN (amount % 10000000  != 0) THEN ' ' ELSE '' END) || amountinwords(amount % 10000000);
END;
$BODY$
  LANGUAGE plpgsql STABLE
  COST 100;