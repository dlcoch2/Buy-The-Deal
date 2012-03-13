-- Drop table if already created
DROP TABLE Deal.Customers;

-- Create Customers table
CREATE TABLE Deal.Customers (
password            VARCHAR(12),
firstName           VARCHAR(20),
lastName            VARCHAR(20),
username            VARCHAR(20) NOT NULL,
phone				VARCHAR(10),
email				VARCHAR(40),
streetAddress		VARCHAR(50),
city				VARCHAR(30),
state				VARCHAR(2),
zipCode				VARCHAR(6),
CCNo				VARCHAR(16),
CCName				VARCHAR(40),
CCExpMonth			VARCHAR(2),
CCExpYear			VARCHAR(4),
CCType				VARCHAR(16)
);

-- Insert test data
INSERT INTO Deal.Customers VALUES('111111', 'Derek', 'Cochran', 'ddog', '3095551234', 'dlcoch2@ilstu.edu', '111 Big Street', 'Bloomington', 'IL', '61704', '1234567890123456', 'Derek Cochran', '02', '2012', 'VISA');

INSERT INTO Deal.Customers VALUES('222222', 'Matt', 'Jarrett', 'mdog', '2173902877', 'mjjarre@ilstu.edu', '123 Small Street', 'Bloomington', 'IL', '61704', '5432109876543210', 'Matthew Jarrett', '08', '2013', 'DISCOVER');

ALTER TABLE Deal.Customers
  ADD CONSTRAINT Deal_customerID_noPK
  PRIMARY KEY (username);