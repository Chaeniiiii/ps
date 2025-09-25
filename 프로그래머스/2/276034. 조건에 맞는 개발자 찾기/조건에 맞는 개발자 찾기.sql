SELECT distinct(d.ID), d.EMAIL, d.FIRST_NAME, d.LAST_NAME
FROM DEVELOPERS d join SKILLCODES s on d.SKILL_CODE & s.CODE = s.CODE
where s.name in ("C#","Python")
order by d.ID;