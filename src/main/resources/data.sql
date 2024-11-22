insert into partheners (id, name)
select 1 AS ID, 'Parceiro 1' AS NAME  FROM TDUAL WHERE NOT EXISTS (SELECT 1 FROM PARTHENERS WHERE NAME='Parceiro 1')
union all
select 2 AS ID, 'Parceiro 2' AS NAME  FROM TDUAL WHERE NOT EXISTS (SELECT 1 FROM PARTHENERS WHERE NAME='Parceiro 2')
union all
select 3 AS ID, 'Parceiro 3' AS NAME  FROM TDUAL WHERE NOT EXISTS (SELECT 1 FROM PARTHENERS WHERE NAME='Parceiro 3');

--Propriedades do frete.
insert into freightproperties (id, name, propertytype)
select 1 AS ID, 'VOLUME' AS NAME, 0 as PROPERTYTYPE  FROM TDUAL WHERE NOT EXISTS (SELECT 1 FROM freightproperties WHERE NAME='VOLUME')
union all
select 2 AS ID, 'CUBAGEM' AS NAME, 1 as PROPERTYTYPE  FROM TDUAL WHERE NOT EXISTS (SELECT 1 FROM freightproperties WHERE NAME='CUBAGEM')
union all
select 3 AS ID, 'PESO CUBADO' AS NAME, 2 as PROPERTYTYPE  FROM TDUAL WHERE NOT EXISTS (SELECT 1 FROM freightproperties WHERE NAME='PESO CUBADO')
