SELECT 
    CustomerKey, 
    COUNT(*) AS TotalOrders
FROM 
    adventureworks_sales_2017
WHERE 
    CustomerKey IN (
        SELECT 
            CustomerKey
        FROM 
            adventureworks_sales_2017
        GROUP BY 
            CustomerKey
        HAVING 
            COUNT(DISTINCT MONTH(OrderDate)) = (SELECT COUNT(DISTINCT MONTH(OrderDate)) FROM adventureworks_sales_2017)
    )
GROUP BY 
    CustomerKey
ORDER BY 
    TotalOrders DESC
LIMIT 1;
