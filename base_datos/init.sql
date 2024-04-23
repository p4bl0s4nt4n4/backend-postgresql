CREATE TABLE charge_points (
    id SERIAL PRIMARY KEY,
    status VARCHAR(50) NOT NULL,
    operator VARCHAR(50) NOT NULL,
    connections INTEGER NOT NULL,
    latitude VARCHAR(50),
    longitude VARCHAR(50),
    country VARCHAR(50) NOT NULL,
    power INTEGER
);

INSERT INTO charge_points (status, operator, connections, latitude, longitude, country, power)
VALUES ('Operational', 'Pogo Charge (GB)', 4, '52.404996329176015', '-1.8853773119496111', 'United Kingdom', 1),
('Operational', 'CV Charging Vehicles', 1, '37.25526749237481', '28.230017878147237', 'Turkey', 2),
('Operational', 'Eranovum (ES)', 2, '38.27780026065781', '-3.6081558700260814', 'Spain', 3),
('Operational', 'Endesa', 4, '38.37507971125979', '-0.507464056552692', 'Spain', 4),
('Planned For Future Date', 'PowerDot (Es)', 2, '36.662303960972295', '-4.474862152715474', 'Spain', 5);