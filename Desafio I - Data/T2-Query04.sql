WITH SalesLastYear AS (
    SELECT 
        s.CustomerKey, 
        SUM(s.OrderQuantity * p.ProductPrice) AS TotalSalesLastYear
    FROM 
        adventureworks_sales_2016 s
    JOIN 
        adventureworks_products p
    ON 
        s.ProductKey = p.ProductKey
    GROUP BY 
        s.CustomerKey
),
SalesThisYear AS (
    SELECT 
        s.CustomerKey,
        SUM(s.OrderQuantity * p.ProductPrice) AS TotalSalesThisYear
    FROM 
        adventureworks_sales_2017 s
    JOIN 
        adventureworks_products p
    ON 
        s.ProductKey = p.ProductKey
    GROUP BY 
        s.CustomerKey
),
SalesGrowth AS (
    SELECT 
        sy.CustomerKey,
        sy.TotalSalesThisYear,
        ly.TotalSalesLastYear,
        (sy.TotalSalesThisYear - ly.TotalSalesLastYear) / ly.TotalSalesLastYear * 100 AS SalesGrowthPercent
    FROM 
        SalesThisYear sy
    JOIN 
        SalesLastYear ly
    ON 
        sy.CustomerKey = ly.CustomerKey
    WHERE 
        ly.TotalSalesLastYear > 0
)
SELECT 
    sg.CustomerKey,
    sg.TotalSalesThisYear,
    sg.SalesGrowthPercent
FROM 
    SalesGrowth sg
JOIN 
    (
        SELECT 
            AVG(TotalSalesThisYear) AS AvgSales
        FROM 
            SalesThisYear
    ) AS AvgSalesTable
ON 
    sg.TotalSalesThisYear > AvgSalesTable.AvgSales
WHERE 
    sg.SalesGrowthPercent > 10
ORDER BY 
    sg.TotalSalesThisYear DESC;
