-- Drop table if already created
DROP TABLE Deal.Purchase;

-- Create Purchase table
CREATE TABLE Deal.Purchase (
purchaseID      integer NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
dealID      	VARCHAR(4),
timeStamp       TIMESTAMP,
totalPrice      DECIMAL(7,2),
username        VARCHAR(20),
title			VARCHAR(25),
price			DECIMAL(7,2),
description		VARCHAR(200)
);

-- Insert test data
INSERT INTO Deal.Purchase (dealID, timestamp, totalPrice, username, title, price, description) VALUES('0001', '2011-03-21 12:03:20', 1499.99, 'mdog', 'iPhone 7', 1499.99, 'Amazing iPhone 7 comes with no new technological advancements, it just costs more!');

INSERT INTO Deal.Purchase (dealID, timestamp, totalPrice, username, title, price, description) VALUES('0002', '2011-03-22 09:25:40', 2.99, 'ddog', '56 Mb Flash Drive', 2.99, 'This technological beast can store up to one full length song!');

ALTER TABLE Deal.Purchase
  ADD CONSTRAINT Deal_purchaseID_noPK
  PRIMARY KEY (purchaseID);