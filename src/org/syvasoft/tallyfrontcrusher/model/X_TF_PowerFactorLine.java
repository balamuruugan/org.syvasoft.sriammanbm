/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.Env;

/** Generated Model for TF_PowerFactorLine
 *  @author iDempiere (generated) 
 *  @version Release 11 - $Id$ */
@org.adempiere.base.Model(table="TF_PowerFactorLine")
public class X_TF_PowerFactorLine extends PO implements I_TF_PowerFactorLine, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20231107L;

    /** Standard Constructor */
    public X_TF_PowerFactorLine (Properties ctx, int TF_PowerFactorLine_ID, String trxName)
    {
      super (ctx, TF_PowerFactorLine_ID, trxName);
      /** if (TF_PowerFactorLine_ID == 0)
        {
			setDateAcct (new Timestamp( System.currentTimeMillis() ));
// @SQL=SELECT now() AS DefaultValue FROM DUAL
			setTF_PowerFactorLine_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_TF_PowerFactorLine (Properties ctx, int TF_PowerFactorLine_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, TF_PowerFactorLine_ID, trxName, virtualColumns);
      /** if (TF_PowerFactorLine_ID == 0)
        {
			setDateAcct (new Timestamp( System.currentTimeMillis() ));
// @SQL=SELECT now() AS DefaultValue FROM DUAL
			setTF_PowerFactorLine_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_PowerFactorLine (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuilder sb = new StringBuilder ("X_TF_PowerFactorLine[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set closingkvah.
		@param closingkvah closingkvah
	*/
	public void setclosingkvah (BigDecimal closingkvah)
	{
		set_Value (COLUMNNAME_closingkvah, closingkvah);
	}

	/** Get closingkvah.
		@return closingkvah	  */
	public BigDecimal getclosingkvah()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_closingkvah);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set closingkwh.
		@param closingkwh closingkwh
	*/
	public void setclosingkwh (BigDecimal closingkwh)
	{
		set_Value (COLUMNNAME_closingkwh, closingkwh);
	}

	/** Get closingkwh.
		@return closingkwh	  */
	public BigDecimal getclosingkwh()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_closingkwh);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Account Date.
		@param DateAcct Accounting Date
	*/
	public void setDateAcct (Timestamp DateAcct)
	{
		set_Value (COLUMNNAME_DateAcct, DateAcct);
	}

	/** Get Account Date.
		@return Accounting Date
	  */
	public Timestamp getDateAcct()
	{
		return (Timestamp)get_Value(COLUMNNAME_DateAcct);
	}

	/** Set Description.
		@param Description Optional short description of the record
	*/
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription()
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set kvahusage.
		@param kvahusage kvahusage
	*/
	public void setkvahusage (BigDecimal kvahusage)
	{
		set_Value (COLUMNNAME_kvahusage, kvahusage);
	}

	/** Get kvahusage.
		@return kvahusage	  */
	public BigDecimal getkvahusage()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_kvahusage);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set kwhusage.
		@param kwhusage kwhusage
	*/
	public void setkwhusage (BigDecimal kwhusage)
	{
		set_Value (COLUMNNAME_kwhusage, kwhusage);
	}

	/** Get kwhusage.
		@return kwhusage	  */
	public BigDecimal getkwhusage()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_kwhusage);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set openingkvah.
		@param openingkvah openingkvah
	*/
	public void setopeningkvah (BigDecimal openingkvah)
	{
		set_Value (COLUMNNAME_openingkvah, openingkvah);
	}

	/** Get openingkvah.
		@return openingkvah	  */
	public BigDecimal getopeningkvah()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_openingkvah);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set openingkwh.
		@param openingkwh openingkwh
	*/
	public void setopeningkwh (BigDecimal openingkwh)
	{
		set_Value (COLUMNNAME_openingkwh, openingkwh);
	}

	/** Get openingkwh.
		@return openingkwh	  */
	public BigDecimal getopeningkwh()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_openingkwh);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set powerfactor.
		@param powerfactor powerfactor
	*/
	public void setpowerfactor (BigDecimal powerfactor)
	{
		set_Value (COLUMNNAME_powerfactor, powerfactor);
	}

	/** Get powerfactor.
		@return powerfactor	  */
	public BigDecimal getpowerfactor()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_powerfactor);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public I_TF_PowerFactor getTF_PowerFactor() throws RuntimeException
	{
		return (I_TF_PowerFactor)MTable.get(getCtx(), I_TF_PowerFactor.Table_ID)
			.getPO(getTF_PowerFactor_ID(), get_TrxName());
	}

	/** Set TF_PowerFactor.
		@param TF_PowerFactor_ID TF_PowerFactor
	*/
	public void setTF_PowerFactor_ID (int TF_PowerFactor_ID)
	{
		if (TF_PowerFactor_ID < 1)
			set_ValueNoCheck (COLUMNNAME_TF_PowerFactor_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_TF_PowerFactor_ID, Integer.valueOf(TF_PowerFactor_ID));
	}

	/** Get TF_PowerFactor.
		@return TF_PowerFactor	  */
	public int getTF_PowerFactor_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_PowerFactor_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set PowerFactorLine.
		@param TF_PowerFactorLine_ID PowerFactorLine
	*/
	public void setTF_PowerFactorLine_ID (int TF_PowerFactorLine_ID)
	{
		if (TF_PowerFactorLine_ID < 1)
			set_ValueNoCheck (COLUMNNAME_TF_PowerFactorLine_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_TF_PowerFactorLine_ID, Integer.valueOf(TF_PowerFactorLine_ID));
	}

	/** Get PowerFactorLine.
		@return PowerFactorLine	  */
	public int getTF_PowerFactorLine_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_PowerFactorLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_PowerFactorLine_UU.
		@param TF_PowerFactorLine_UU TF_PowerFactorLine_UU
	*/
	public void setTF_PowerFactorLine_UU (String TF_PowerFactorLine_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_PowerFactorLine_UU, TF_PowerFactorLine_UU);
	}

	/** Get TF_PowerFactorLine_UU.
		@return TF_PowerFactorLine_UU	  */
	public String getTF_PowerFactorLine_UU()
	{
		return (String)get_Value(COLUMNNAME_TF_PowerFactorLine_UU);
	}

	/** Set unit.
		@param unit unit
	*/
	public void setunit (BigDecimal unit)
	{
		set_Value (COLUMNNAME_unit, unit);
	}

	/** Get unit.
		@return unit	  */
	public BigDecimal getunit()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_unit);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Unit Factor.
		@param UnitFactor Unit Factor
	*/
	public void setUnitFactor (BigDecimal UnitFactor)
	{
		set_Value (COLUMNNAME_UnitFactor, UnitFactor);
	}

	/** Get Unit Factor.
		@return Unit Factor	  */
	public BigDecimal getUnitFactor()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_UnitFactor);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	@Override
	public void setTonnage(BigDecimal Tonnage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BigDecimal getTonnage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUnit_Price(BigDecimal Unit_Price) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BigDecimal getUnit_Price() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUnits(BigDecimal Units) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BigDecimal getUnits() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUnitPerMT(BigDecimal UnitPerMT) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BigDecimal getUnitPerMT() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEBCost(BigDecimal EBCost) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BigDecimal getEBCost() {
		// TODO Auto-generated method stub
		return null;
	}
}