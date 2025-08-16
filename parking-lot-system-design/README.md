# Parking Lot

## Requirements:
1. parking lot should have multiple types of parking spots.
    1. accessible
    2. compact
    3. large
    4. motorcycle
2. parking lot can have multiple entry and exit points.
3. should support 4 types of vehicles:
    1. Car
    2. Truck
    3. Van
    4. Motorcycle
4. should be multi-level
5. each level should have a display board showing number of available parking spots for each parking spot type.
6. When parking lot is full no vehicle should be allowed and there should be a clear message on the board.
7. users will get the parking ticket on entry which will be used to track parking time and calculate paymentReceipt at exit.
8. configurable pricing for type of vehicle and/or parking spot type and different rates for different durations. (first hour x price, further hours y price).
9. paymentReceipt can be accepted via credit card/upi/cash.

## UML:
![parking-lot-uml][parking-lot-system-design/parking-lot-uml.png]

## Entities:
### EntryGate
- id: string
- parkingLot: ParkingLot
+ generateTicket(vehicle): Ticket

### ExitGate
- id: string
- parkingLot: ParkingLot
+ processTicket(ticket): Payment

### ParkingLot
- levels: List<Level>
- entryGates: List<EntryGate>
- exitGates: List<ExitGate>
- pricingPolicy: PricingPolicy
+ assignSpot(vehicle): Ticket
+ unassignSpot(ticket): Payment
+ isFull(): boolean

### Level
- floorNumber: int
- spots: Map<ParkingSpotType, List<ParkingSpot>>
- displayBoard: DisplayBoard
+ parkVehicle(v: V): Ticket
+ isFull(): boolean

### DisplayBoard
- availableSpots: Map<ParkingSpotType, Integer>
+ update(map): void

### ParkingSpot
- id: string
- free: boolean
- type: ParkingSpotType
- vehicle: Vehicle
+ canFit(v: Vehicle): boolean
+ assign(vehicle, level): Ticket
+ unassign(ticket, paymentType): Payment
+ isFree(): boolean

### ParkingSpotType (enum)
- ACCESSIBLE
- COMPACT
- LARGE
- MOTORCYCLE

### VehicleType (enum)
- CAR
- TRUCK
- VAN
- MOTORCYCLE

### Vehicle (abstract)
- vehicleType: VehicleType
- licenseNumber: string
+ getType() -> VehicleType

#### Car
#### Truck
#### Van
#### Motorcycle


### Ticket
- id: string
- vehicle: Vehicle
- spot: ParkingSpot
- entryTime: LocalDateTime
- level: Level
+ getDurationInHours(): long
+ getSpot(): ParkingSpot
+ getVehicle(): Vehicle

### PaymentType (enum)
- CASH
- CREDIT_CARD
- UPI
 
### Payment
- id: string
- amount: double
- timestamp: LocalDateTime
- paymentType: PaymentType

## PricingPolicy
- rateCard: Map<VehicleType, Map<Integer, Double>>
+ calculate(ticket: Ticket) -> double
