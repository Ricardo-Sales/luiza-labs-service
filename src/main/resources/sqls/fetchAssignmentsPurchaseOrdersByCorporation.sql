SELECT DISTINCT assignment.NAME AS "NAME", assignment.USER_ID AS "USER_ID"
FROM documents.ENTITIES_RELATIONS purchaseOrder
INNER JOIN documents.ENTITIES_RELATIONS corporation ON corporation.id = purchaseOrder.ASSIGNED
INNER JOIN documents.ASSIGNMENTS assignment ON assignment.ENTITY_RELATION = purchaseOrder.ID
LEFT JOIN documents.THIRDPARTIES thirdParties ON thirdParties.ENTITY_RELATION = purchaseOrder.id
WHERE purchaseOrder.TAG = 5
AND (corporation.REFERENCE IN (<corporationIds>) OR thirdParties.COMPANY IN (<corporationIds>))
AND corporation.TAG IN (3,29)
AND ASSIGNMENT."role" = :role