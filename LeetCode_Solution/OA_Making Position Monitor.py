# Implement the class below, keeping the constructor's signature unchanged; it should take no arguments.


import json


class MarkingPositionMonitor:
    def __init__(self):
        self.order = {}
        self.pos = {}

    def on_event(self, message):
        event = json.loads(message)
        type = event["type"]
        if type == "NEW":
            return self.newOrder(event)
        elif type == "ORDER_ACK":
            return self.orderAck(event)
        elif type == "ORDER_REJECT":
            return self.orderReject(event)
        elif type == "CANCEL":
            return self.cancel(event)
        elif type == "CANCEL_ACK":
            return self.cancelAck(event)
        elif type == "CANCEL_REJECT":
            return self.cancelReject(event)
        elif type == "FILL":
            return self.fill(event)
    
    # new order requested by firm
    def newOrder(self, event):
        symbol = event["symbol"]
        order_id = event["order_id"]
        quantity = event["quantity"]
        side = event["side"]
        
        if side == "BUY":
            self.order[order_id] = {
                "symbol": symbol, 
                "side": "BUY", 
                "quantity": quantity, 
                "filled": 0}
            self.pos[symbol] = self.pos.get(symbol, 0)
        if side == "SELL":
            self.order[order_id] = {
                "symbol": symbol, 
                "side": "SELL", 
                "quantity": quantity, 
                "filled": 0}
            self.pos[symbol] = self.pos.get(symbol, 0) - quantity
        
        return self.pos[symbol]

    # new order acknowledged by the exchange
    def orderAck(self, event):
        order_id = event["order_id"]
        symbol = self.order[order_id]["symbol"]
        return self.pos[symbol]
    
    # new order rejected by the exchange
    def orderReject(self, event):
        order_id = event["order_id"]
        symbol = self.order[order_id]["symbol"]
        
        if order_id in self.order:
            if "reject" not in self.order[order_id]:
                self.order[order_id]["reject"] = True
                if self.order[order_id]["side"] == "SELL":
                    quantity = self.order[order_id]["quantity"]
                    self.pos[symbol] += quantity
            return self.pos[symbol]
        else:
            return 0

    # cancel order requested by firm
    def cancel(self, event):
        order_id = event["order_id"]
        if order_id in self.order:
            symbol = self.order[order_id]["symbol"]
            return self.pos[symbol]
        else:
            return 0
    
    # cancel order acknowledged by the exchange
    def cancelAck(self, event):
        order_id = event["order_id"]
        symbol = self.order[order_id]["symbol"]
        quantity = self.order[order_id]["quantity"]
        
        if self.order[order_id]["side"] == "SELL":
            self.pos[symbol] += quantity
        return self.pos[symbol]
    
    # cancel order rejected by the exchange
    def cancelReject(self, event):
        order_id = event["order_id"]
        if order_id in self.order:
            symbol = self.order[order_id]["symbol"]
            return self.pos[symbol]
        else:
            return 0
    
    # order completed
    def fill(self, event):
        order_id = event["order_id"]
        fill = event["filled_quantity"]
        
        symbol = self.order[order_id]["symbol"]
        side = self.order[order_id]["side"]
        
        if order_id in self.order:
            # part filled, quantity decreased
            if fill <= self.order[order_id]["quantity"]:
                self.order[order_id]["filled"] += fill
                self.order[order_id]["quantity"] -= fill
            # all filled, quantity cleared
            else:
                fill = self.order[order_id]["quantity"]
                self.order[order_id]["filled"] += fill
                self.order[order_id]["quantity"] = 0
                
            if side == "BUY":
                self.pos[symbol] += fill
                
            return self.pos[symbol]
        else:
            return 0
