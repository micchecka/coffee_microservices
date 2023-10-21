CREATE OR REPLACE FUNCTION insert_into_item() RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO item (item_id) VALUES (NEW.item_id);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;


CREATE TRIGGER trigger_insert_into_item_food
    BEFORE INSERT ON food
    FOR EACH ROW
EXECUTE FUNCTION insert_into_item();

CREATE TRIGGER trigger_insert_into_item_coffee
    BEFORE INSERT ON coffee
    FOR EACH ROW
EXECUTE FUNCTION insert_into_item();


INSERT INTO tag (tag_id, tag_name)
VALUES (nextval('tag_id_sequence'), 'Кофе'),
       (nextval('tag_id_sequence'),'Молоко'),
       (nextval('tag_id_sequence'),'Выпечка');

-- INSERT INTO item (item_id) VALUES (nextval('item_id_sequence'));

-- INSERT INTO coffee (item_id, coffee_name, coffee_description, coffee_image, coffee_price)
-- VALUES ((nextval('item_id_sequence')),
--         'Laste', 'Кофейный напиток с молоком и каплями эспрессо',
--         'https://disk.yandex.ru/i/rNUgHbM71zDRVg', 220);
--
--  INSERT INTO food (item_id, food_name, food_description, food_image, food_price)
--  VALUES ((nextval('item_id_sequence')),
--          'Круассан', 'Французская булка',
--          'https://a.d-cd.net/f164efu-960.jpg', 200);

-- Вставляем кофе и возвращаем его ID
WITH inserted_coffee AS (
    INSERT INTO coffee (item_id, coffee_name, coffee_description, coffee_image, coffee_price)
        VALUES (nextval('item_id_sequence'), 'Latte', 'Кофейный напиток с молоком и каплями эспрессо', 'https://disk.yandex.ru/i/rNUgHbM71zDRVg', 220)
        RETURNING item_id
)
-- Вставляем связь кофе с тегами 'Кофе' и 'Молоко'
INSERT INTO item_tags (item_id, tag_id)
SELECT inserted_coffee.item_id, tag.tag_id
FROM inserted_coffee, tag
WHERE tag.tag_name IN ('Кофе', 'Молоко');

-- Вставляем круассан и возвращаем его ID
WITH inserted_food AS (
    INSERT INTO food (item_id, food_name, food_description, food_image, food_price)
        VALUES (nextval('item_id_sequence'), 'Круассан', 'Французская булка', 'https://a.d-cd.net/f164efu-960.jpg', 200)
        RETURNING item_id
)
-- Вставляем связь круассана с тегом 'Выпечка'
INSERT INTO item_tags (item_id, tag_id)
SELECT inserted_food.item_id, tag.tag_id
FROM inserted_food, tag
WHERE tag.tag_name = 'Выпечка';

