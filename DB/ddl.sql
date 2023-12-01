CREATE database vote;

CREATE TABLE vote_item
(
    item_id            INT             NOT NULL PRIMARY KEY AUTO_INCREMENT,
    item_name          VARCHAR(128)    NOT NULL,
    item_status        INT             NOT NULL,
    create_date        TIMESTAMP       NOT NULL,
    last_modified_date TIMESTAMP       NOT NULL
);

CREATE TABLE vote_record
(
    record_id          INT             NOT NULL PRIMARY KEY AUTO_INCREMENT,
    record_name        VARCHAR(128)    NOT NULL,
    item_id            INT             NOT NULL,
    create_date        TIMESTAMP       NOT NULL,
    CONSTRAINT  FK_item_record  FOREIGN KEY (item_id)
        REFERENCES vote_item (item_id)
);

DELIMITER $$
CREATE PROCEDURE get_vote_item(
    IN itemId INT)
BEGIN
SELECT item_id, item_name, item_status, create_date, last_modified_date
FROM vote_item
WHERE item_id = itemId;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE get_vote_item_list()
BEGIN
SELECT item_id, item_name, item_status, create_date, last_modified_date
FROM vote_item;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE get_vote_item_with_sum_list()
BEGIN
SELECT vote_item.item_id, vote_item.item_name, COUNT(vote_record.record_name) AS sum
FROM vote_item
    LEFT JOIN vote_record ON vote_item.item_id = vote_record.item_id
WHERE vote_item.item_status = 1
GROUP BY vote_item.item_id;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE create_vote_item(
    IN itemName VARCHAR(128),
    IN itemStatus INT,
    IN createDate TIMESTAMP,
    IN lastModifiedDate TIMESTAMP,
    OUT itemId INT)
BEGIN
INSERT INTO vote_item (item_name, item_status, create_date, last_modified_date)
VALUES (itemName, itemStatus, createDate, lastModifiedDate);
SET itemId = last_insert_id();
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE update_vote_item(
    IN itemId INT,
    IN itemStatus INT,
    IN lastModifiedDate TIMESTAMP)
BEGIN
UPDATE vote_item
SET item_status = itemStatus, last_modified_date = lastModifiedDate
WHERE item_id = itemId;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE create_vote_record(
    IN recordName VARCHAR(128),
    IN itemId INT,
    IN createDate TIMESTAMP)
BEGIN
INSERT INTO vote_record (record_name, item_id, create_date)
VALUES (recordName, itemId, createDate);
END $$
DELIMITER ;