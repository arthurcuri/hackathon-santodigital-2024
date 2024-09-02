SELECT 
    MONTH(OrderDate) AS OrderMonth,
    SUM(OrderQuantity * ProductPrice) AS TotalSales
FROM 
    (
        SELECT 
            s.OrderDate, 
            s.OrderQuantity, 
            p.ProductPrice
        FROM 
            adventureworks_sales_2015 s
        JOIN 
            adventureworks_products p
        ON 
            s.ProductKey = p.ProductKey
        
        UNION ALL
        
        SELECT 
            s.OrderDate, 
            s.OrderQuantity, 
            p.ProductPrice
        FROM 
            adventureworks_sales_2016 s
        JOIN 
            adventureworks_products p
        ON 
            s.ProductKey = p.ProductKey
        
        UNION ALL
        
        SELECT 
            s.OrderDate, 
            s.OrderQuantity, 
            p.ProductPrice
        FROM 
            adventureworks_sales_2017 s
        JOIN 
            adventureworks_products p
        ON 
            s.ProductKey = p.ProductKey
    ) AS AllSales
GROUP BY 
    MONTH(OrderDate)
HAVING 
    AVG(OrderQuantity * ProductPrice) > 500
ORDER BY 
    TotalSales DESC
LIMIT 1;
