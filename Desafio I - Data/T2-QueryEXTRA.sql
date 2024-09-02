WITH ProductSales AS (
    SELECT 
        p.ProductKey,
        p.ProductName,
        ps.ProductSubcategoryKey,
        SUM(s.OrderQuantity) AS TotalQuantitySold
    FROM 
        adventureworks_sales_2017 s
    JOIN 
        adventureworks_products p
    ON 
        s.ProductKey = p.ProductKey
    JOIN 
        adventureworks_product_subcategories ps
    ON 
        p.ProductSubcategoryKey = ps.ProductSubcategoryKey
    GROUP BY 
        p.ProductKey, p.ProductName, ps.ProductSubcategoryKey
),
CategoryAverageSales AS (
    SELECT 
        ps.ProductSubcategoryKey,
        AVG(ps.TotalQuantitySold) AS AvgCategorySales
    FROM 
        ProductSales ps
    GROUP BY 
        ps.ProductSubcategoryKey
),
RankedProductSales AS (
    SELECT 
        ps.ProductKey,
        ps.ProductName,
        ps.ProductSubcategoryKey,
        ps.TotalQuantitySold,
        cas.AvgCategorySales,
        ROW_NUMBER() OVER (PARTITION BY ps.ProductSubcategoryKey ORDER BY ps.TotalQuantitySold DESC) AS SalesRank
    FROM 
        ProductSales ps
    JOIN 
        CategoryAverageSales cas
    ON 
        ps.ProductSubcategoryKey = cas.ProductSubcategoryKey
)
SELECT 
    rps.ProductSubcategoryKey,
    rps.ProductName,
    rps.TotalQuantitySold,
    rps.AvgCategorySales
FROM 
    RankedProductSales rps
WHERE 
    rps.SalesRank <= 5
ORDER BY 
    rps.ProductSubcategoryKey, rps.TotalQuantitySold DESC;
