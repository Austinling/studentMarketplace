import { MainSection } from "../features/auth/components/MainSection";
import { TopNavBar } from "../features/auth/components/TopNavBar";
import { InstructionsContainer } from "../features/homePage/components/InstructionsContainer";
import { MainPageCatalog } from "../features/homePage/components/MainPageCatalog";

export default function HomePage() {
  return (
    <div>
      <MainSection />
      <MainPageCatalog />
      <InstructionsContainer />
    </div>
  );
}
