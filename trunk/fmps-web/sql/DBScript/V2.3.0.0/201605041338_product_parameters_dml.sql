UPDATE `fmps`.`product_parameters` SET `description`='请填写台湾学校' WHERE  `id`=16;
UPDATE `fmps`.`product_parameters` SET `description`='请填写大陆学校' WHERE  `id`=9;
INSERT INTO `product_parameters` (`id`, `productid`, `type`, `param_key`, `param_value`, `description`, `planid`) VALUES (17, '8a8195b3542d7bc201542d89e3d50000', 'general', 'toTai', 'Y', '请填写大陆学校', NULL);
INSERT INTO `product_parameters` (`id`, `productid`, `type`, `param_key`, `param_value`, `description`, `planid`) VALUES (18, '8a8195b3535abc8301535e1e56080001', 'general', 'department', 'Y', '请填写院系及学号', NULL);
