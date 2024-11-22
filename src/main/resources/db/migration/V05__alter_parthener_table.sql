ALTER TABLE freights ADD CONSTRAINT fk_freightproperties FOREIGN KEY (freightproperty_id) REFERENCES freightproperties(id) ON DELETE CASCADE;
ALTER TABLE freights ADD CONSTRAINT fk_partheners FOREIGN KEY (parthener_id) REFERENCES partheners(id) ON DELETE CASCADE;
