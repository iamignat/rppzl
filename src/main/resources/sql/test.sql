INSERT INTO suppliers (name, contact_info, rating)
VALUES
    ('Поставщик 1', 'contact1@example.com', 4.5),
    ('Поставщик 2', 'contact2@example.com', 3.8),
    ('Поставщик 3', 'contact3@example.com', 4.9),
    ('Поставщик 4', 'contact4@example.com', 2.7),
    ('Поставщик 5', 'contact5@example.com', 4.2);

INSERT INTO contracts (supplier_id, start_date, end_date, terms)
VALUES
    (1, '2024-01-01', '2025-01-01', 'Оплата через 30 дней после получения товара'),
    (2, '2024-06-01', '2025-06-01', 'Ежемесячные поставки на условиях предоплаты'),
    (3, '2024-03-15', '2025-03-15', 'Поставка по запросу в любое время'),
    (4, '2024-07-01', '2025-07-01', 'Оплата в рассрочку 3 месяца'),
    (5, '2024-08-01', '2025-08-01', 'Оплата по факту поставки');

INSERT INTO purchase_request (description, created_date, status)
VALUES
    ('Запрос на закупку офисных стульев', '2024-11-01', 'NEW'),
    ('Запрос на закупку компьютеров для сотрудников', '2024-11-15', 'APPROVED'),
    ('Запрос на закупку оборудования для склада', '2024-10-20', 'REJECTED'),
    ('Запрос на закупку мебели для переговорных', '2024-09-10', 'APPROVED'),
    ('Запрос на закупку канцелярских товаров', '2024-12-01', 'NEW');

INSERT INTO supply_orders (purchase_request_id, supplier_id, order_date, status)
VALUES
    (1, 1, '2024-11-10', 'PENDING'),
    (2, 2, '2024-11-16', 'COMPLETED'),
    (3, 3, '2024-10-22', 'CANCELLED'),
    (4, 4, '2024-09-12', 'PENDING'),
    (5, 5, '2024-12-05', 'COMPLETED');

INSERT INTO delivery_schedules (supply_order_id, delivery_date, priority, delivery_time, status, supplier_rating)
VALUES
    (1, '2024-11-15', 1, 2, 'PENDING', 4),
    (2, '2024-11-20', 2, 3, 'COMPLETED', 5),
    (3, '2024-10-25', 3, 1, 'CANCELLED', 3),
    (4, '2024-09-15', 1, 2, 'PENDING', 4),
    (5, '2024-12-10', 2, 4, 'COMPLETED', 5);


