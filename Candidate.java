package com.example.razzle.govote;

public class Candidate
{
    private String name;
    private String party;
    private boolean supportAbortion;
    private boolean supportEducation;
    private boolean supportGunControl;
    private boolean supportLGBTQRights;
    private boolean supportTaxReform;

    public Candidate (String n, String p, boolean sa, boolean se, boolean sg, boolean sr, boolean st)
    {
        name = n;
        party = p;
        supportAbortion = sa;
        supportEducation = se;
        supportGunControl = sg;
        supportLGBTQRights = sr;
        supportTaxReform = st;
    }

    public String getName()
    {
        return name;
    }

    public String getParty()
    {
        return party;
    }

    public boolean getSupportAbortion()
    {
        return supportAbortion;
    }

    public boolean getSupportEducation()
    {
        return supportEducation;
    }

    public boolean getSupprtGunControl()
    {
        return supportGunControl;
    }

    public boolean getSupportLGBTQRights()
    {
        return supportLGBTQRights;
    }

    public boolean getSupportTaxReform()
    {
        return supportTaxReform;
    }
}