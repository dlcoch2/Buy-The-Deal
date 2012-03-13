-- Drop table if already created
DROP TABLE Deal.Deal;

-- Create Deal table
CREATE TABLE Deal.Deal (
dealID          VARCHAR(4) NOT NULL,
title			VARCHAR(25),
price			DECIMAL(7,2),
description		VARCHAR(200)
);

-- Insert test data
INSERT INTO Deal.Deal VALUES('0001', 'iPhone 7', 1499.99, 'Amazing iPhone 7 comes with no new technological advancements, it just costs more!');

INSERT INTO Deal.Deal VALUES('0002', '56 Mb Flash Drive', 2.99, 'This technological beast can store up to one full length song!');

INSERT INTO Deal.Deal VALUES('0003', 'MacBook Book Case', 29.99, 'This is an expensive and quality means to protecting your MacBook!');

INSERT INTO Deal.Deal VALUES('0004', 'Star Wars Toaster', 45.99, 'Show those pesky Jedi which side you are on with this great toaster.  It toasts your dark lords face on your breakfast!');

INSERT INTO Deal.Deal VALUES('0005', 'Pixel Oven Mitts', 9.99, 'Retrieve your hot food in awesome 8 bit style!');

ALTER TABLE Deal.Deal
  ADD CONSTRAINT Deal_dealID_noPK
  PRIMARY KEY (dealID);