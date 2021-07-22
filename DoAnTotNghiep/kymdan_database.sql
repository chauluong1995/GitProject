use kymdan;

# role
insert into kymdan.app_role (id, role_name) values (1, 'Admin');
insert into kymdan.app_role (id, role_name) values (2, 'Employee');
insert into kymdan.app_role (id, role_name) values (3, 'Customer');

# account
insert into kymdan.app_account (id, `password`, username, app_role_id) values (1, '$2a$10$9JSTCvzf.qJkKZui25Nj8uHSp.x3LxcyN9MfWqo8ilU7g8VLn2Fkq', 'Lê Phương Thảo', 1);
insert into kymdan.app_account (id, `password`, username, app_role_id) values (2, '$2a$10$9JSTCvzf.qJkKZui25Nj8uHSp.x3LxcyN9MfWqo8ilU7g8VLn2Fkq', 'Hoàng Linh Giang', 2);
insert into kymdan.app_account (id, `password`, username, app_role_id) values (3, '$2a$10$9JSTCvzf.qJkKZui25Nj8uHSp.x3LxcyN9MfWqo8ilU7g8VLn2Fkq', 'SuPea Junior', 3);

# employee, customer
insert into kymdan.app_admin (id, full_name, gender, birthday, address, phone, email, app_account_id) values (1, 'Lê Phương Thảo', 'Nữ', '1973-11-15', 'Đăk Lăk', '0905456789', 'phuongthao@gmail.com', 1);
insert into kymdan.employee (id, full_name, gender, birthday, address, phone, email, app_account_id) values (2, 'Hoàng Linh Giang', 'Nữ', '1999-08-05', 'Đăk Lăk', '0769555555', 'linhgiang05081999@gmail.com', 2);
insert into kymdan.customer (id, full_name, gender, birthday, address, phone, email, app_account_id) values (3, 'SuPea Junior', 'Nam', '1995-05-27', 'Quảng Nam', '0905999999', 'supea@gmail.com', 3);

# product type
insert into kymdan.product_type (id, type_name, url) values (1, 'Nệm (mattress) KYMDAN Deluxe', 'https://www.kymdan.com/attachment.do?file=attachment/6140/nem%20kymdan%20deluxe_128x96.jpg');
insert into kymdan.product_type (id, type_name, url) values (2, 'Nệm xếp (folding mattress) KYMDAN UltimateCare', 'https://www.kymdan.com/attachment.do?file=attachment/9718/xep-water-cover-avatar_128x96.jpg');
insert into kymdan.product_type (id, type_name, url) values (3, 'Nệm (mattress) KYMDAN Deluxe Premium', 'https://www.kymdan.com/attachment.do?file=attachment/11182/20200714_sanpham_ngonngu_nem_Premium_sliders_IMG_4929-ghep_goc_hong_128x96.jpg');
insert into kymdan.product_type (id, type_name, url) values (4, 'Nệm xếp (folding mattress) KYMDAN Premium', 'https://www.kymdan.com/attachment.do?file=attachment/4076/HINH%20NEM%20XEP%201_128x96.png');
insert into kymdan.product_type (id, type_name, url) values (5, 'Nệm xếp (folding mattress) KYMDAN Mini', 'https://www.kymdan.com/attachment.do?file=attachment/11/nem-xep-tre-em(l)_128x96.jpg');
insert into kymdan.product_type (id, type_name, url) values (6, 'Nệm (mattress) KYMDAN Massage', 'https://www.kymdan.com/attachment.do?file=attachment/6436/nem_kymdan_massage_01_128x96.jpg');
insert into kymdan.product_type (id, type_name, url) values (7, 'Nệm (mattress) KYMDAN Mini', 'https://www.kymdan.com/attachment.do?file=attachment/10/kd_child_128x96.jpg');
insert into kymdan.product_type (id, type_name, url) values (8, 'Nệm (mattress) KYMDAN Du Lịch', 'https://www.kymdan.com/attachment.do?file=attachment/11190/20200707_sanpham_ngonngu_nem_du_lich-avatar_128x96.jpg');
insert into kymdan.product_type (id, type_name, url) values (9, 'Nệm xếp (folding mattress) KYMDAN', 'https://www.kymdan.com/attachment.do?file=attachment/5292/ao_nem_xep_128x96.jpg');